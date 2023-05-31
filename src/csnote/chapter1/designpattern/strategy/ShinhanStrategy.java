package csnote.chapter1.designpattern.strategy;

public class ShinhanStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public ShinhanStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using ShinhanCard.");
    }
}
