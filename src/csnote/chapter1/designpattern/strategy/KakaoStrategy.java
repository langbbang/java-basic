package csnote.chapter1.designpattern.strategy;

public class KakaoStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvc;
    private String dateOfExpiry;

    public KakaoStrategy(String name, String cardNumber, String cvc, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using KakaoCard.");
    }
}
