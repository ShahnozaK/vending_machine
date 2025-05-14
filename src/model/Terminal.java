package model;

public class Terminal extends PaymentMethod {
    private int cardNumber;
    private int password;

    public Terminal(int amount, int cardNumber, int password) {
        super(amount);
        this.cardNumber = cardNumber;
        this.password = password;
    }


    @Override
    boolean pay(int amount) {
        return false;
    }
}
