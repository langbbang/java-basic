package csnote.chapter1.designpattern.factory;

public abstract class Coffee {
    public abstract int getPrice();

    @Override
    public String toString() {
        return "Hi this coffee is " + getPrice();
    }
}
