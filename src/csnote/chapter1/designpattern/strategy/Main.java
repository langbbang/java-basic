package csnote.chapter1.designpattern.strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Item item1 = new Item("책", 1000);
        Item item2 = new Item("연필", 300);

        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        // 카카오카드로 결제
        shoppingCart.pay(new KakaoStrategy("홍길동", "1234-1234-1234-1234", "123", "5/31"));
        // 신한카드로 결제
        shoppingCart.pay(new ShinhanStrategy("lang_11@naver.com", "password"));
    }
}