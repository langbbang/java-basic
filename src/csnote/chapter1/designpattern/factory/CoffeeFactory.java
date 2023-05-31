package csnote.chapter1.designpattern.factory;

import java.util.HashMap;
import java.util.Map;

public class CoffeeFactory {
    private static final Map<String, Coffee> coffeeFactory = new HashMap<>();

    static {
        coffeeFactory.put(CoffeeType.LATTE.getName(), new Latte(4000));
        coffeeFactory.put(CoffeeType.AMERICANO.getName(), new Americano(3000));
        coffeeFactory.put(CoffeeType.DEFAULT.getName(), new DefaultCoffee());
    }

    // map에서 꺼내서 매핑
    public static Coffee getCoffeeWithMap(String type, int price) {
        Coffee coffee = coffeeFactory.get(type);
        return coffee != null ? coffee : coffeeFactory.get(CoffeeType.DEFAULT.getName());
    }

    // ENUM 사용하여 타입 분기
    public static Coffee getCoffeeWithEnum(String type, int price) {
        if (CoffeeType.LATTE.equals(type)) {
            return new Latte(price);
        } else if (CoffeeType.AMERICANO.equals(type)) {
            return new Americano(price);
        } else {
            return new DefaultCoffee();
        }
    }

    // 문자열 비교를 통해 if 분기 태우는 기본 로직
    public static Coffee getCoffee(String type, int price) {
        if ("Latte".equalsIgnoreCase(type)) {
            return new Latte(price);
        } else if ("Americano".equalsIgnoreCase(type)) {
            return new Americano(price);
        } else {
            return new DefaultCoffee();
        }
    }
}
