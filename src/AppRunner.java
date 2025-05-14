import enums.ActionLetter;
import model.*;
import util.UniversalArray;
import util.UniversalArrayImpl;

import java.util.Scanner;

public class AppRunner {

    private final UniversalArray<Product> products = new UniversalArrayImpl<>();

    private final PaymentMethod paymentMethod;

    private static boolean isExit = false;

    private AppRunner() {
        products.addAll(new Product[]{
                new Water(ActionLetter.B, 20),
                new CocaCola(ActionLetter.C, 50),
                new Soda(ActionLetter.D, 30),
                new Snickers(ActionLetter.E, 80),
                new Mars(ActionLetter.F, 80),
                new Pistachios(ActionLetter.G, 130)
        });
        paymentMethod = choosePayingMethod();
    }

    public static void run() {
        AppRunner app = new AppRunner();
        while (!isExit) {
            app.startSimulation();
        }
    }

    private void startSimulation() {
        print("В автомате доступны:");
        showProducts(products);

        print("Денег на сумму: " + paymentMethod.getAmount());

        UniversalArray<Product> allowProducts = new UniversalArrayImpl<>();
        allowProducts.addAll(getAllowedProducts().toArray());
        chooseAction(allowProducts);

    }

    private UniversalArray<Product> getAllowedProducts() {
        UniversalArray<Product> allowProducts = new UniversalArrayImpl<>();
        for (int i = 0; i < products.size(); i++) {
            if (paymentMethod.getAmount() >= products.get(i).getPrice()) {
                allowProducts.add(products.get(i));
            }
        }
        return allowProducts;
    }

    private void chooseAction(UniversalArray<Product> products) {
        showActions(products);
        print(" h - Выйти");
        String action = fromConsole().substring(0, 1);
        try {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getActionLetter().equals(ActionLetter.valueOf(action.toUpperCase()))) {
                    paymentMethod.setAmount(paymentMethod.getAmount() - products.get(i).getPrice());
                    print("Вы купили " + products.get(i).getName());
                    break;
                } else if ("h".equalsIgnoreCase(action)) {
                    isExit = true;
                    break;
                }
            }
        } catch (IllegalArgumentException e) {
            print("Недопустимая буква. Попрбуйте еще раз.");
            chooseAction(products);
        }


    }

    private void showActions(UniversalArray<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            print(String.format(" %s - %s", products.get(i).getActionLetter().getValue(), products.get(i).getName()));
        }
    }

    private String fromConsole() {
        return new Scanner(System.in).nextLine();
    }

    private void showProducts(UniversalArray<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            print(products.get(i).toString());
        }
    }

    private void print(String msg) {
        System.out.println(msg);
    }

    private PaymentMethod choosePayingMethod() {
        System.out.println("Выберите способ оплаты: ");
        System.out.println("1 - наличными");
        System.out.println("2 - монетами");
        System.out.println("3 - картой");
        Scanner sc = new Scanner(System.in);
        int numberOfMethod = sc.nextInt();

        if (numberOfMethod == 1) {
            System.out.println("Введите сумму для оплаты наличными: ");
            Scanner scan = new Scanner(System.in);
            int cash = sc.nextInt();
            return new CashAcceptor(cash);
        } else if (numberOfMethod == 2) {
            System.out.println("Внесите сумму монет: ");
            Scanner scan = new Scanner(System.in);
            int cash = sc.nextInt();
            return new CoinAcceptor(cash);

        } else if (numberOfMethod == 3) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите номер карты: ");
            int cardNumber = scan.nextInt();
            System.out.println("Введите пароль: ");
            int password = scan.nextInt();
            System.out.println("Введите сумму для списания: ");
            int sum = scan.nextInt();
            return new Terminal(sum, cardNumber, password);

        } else {
            System.out.println("Введено неверное число, попробуйте еще раз!");
        }
        return choosePayingMethod();
    }

    }