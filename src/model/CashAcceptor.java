package model;

import util.UniversalArray;
import util.UniversalArrayImpl;

public class CashAcceptor extends PaymentMethod{
    @Override
    boolean pay(int amount) {
        return false;
    }

    @Override
    void startSimulation() {
        System.out.println();("В автомате доступны:");
            showProducts(products);

            print("Монет на сумму: " + coinAcceptor.getAmount());

            UniversalArray<Product> allowProducts = new UniversalArrayImpl<>();
            allowProducts.addAll(getAllowedProducts().toArray());
            chooseAction(allowProducts);


    }


//    boolean pay(int amount) {
//        int amountOfMoney = 0;
//        if (amountOfMoney < 20) {
//            System.out.println("Недостаточно средств, оплата не прошла. Попробуйте еще раз!");
//            return false;
//        } else {
//
//        }
//
//    }


}
