package model;

public class CoinAcceptor extends PaymentMethod {

    public CoinAcceptor(int amount) {
        super(amount);
    }

    @Override
    boolean pay(int amount) {
        return false;
    }
}