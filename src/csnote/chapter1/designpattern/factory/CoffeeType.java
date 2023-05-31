package csnote.chapter1.designpattern.factory;

public enum CoffeeType {
    DEFAULT("DEFAULT", "기본"),
    AMERICANO("AMERICANO", "아메리카노"),
    LATTE("LATTE", "라떼");

    CoffeeType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public boolean equals(String name) {
        return this.name.equalsIgnoreCase(name);
    }
}
