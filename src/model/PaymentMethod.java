package model;

import util.UniversalArray;
import util.UniversalArrayImpl;

import java.util.Scanner;

public abstract class PaymentMethod {
    int amount;

    abstract boolean pay(int amount);

    public PaymentMethod(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}


