package model;

import util.UniversalArray;
import util.UniversalArrayImpl;

import java.util.Scanner;

public abstract class PaymentMethod {
    public PaymentMethod() {
    }



    abstract boolean pay(int amount);

}


