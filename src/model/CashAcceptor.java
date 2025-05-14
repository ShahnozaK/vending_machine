package model;

import util.UniversalArray;
import util.UniversalArrayImpl;

import java.util.Scanner;

public class CashAcceptor extends PaymentMethod{

    public CashAcceptor(int amount) {
        super(amount);
    }

    @Override
    boolean pay(int amount) {
        return false;
    }

    public static void payingWithCash() {
        System.out.println("Введите сумму для оплаты наличными: ");
        Scanner sc = new Scanner(System.in);
         int cash = sc.nextInt();

    }
}





