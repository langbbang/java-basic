package csnote.chapter1.designpattern.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        if (a == b) {
            System.out.println(true);
        }
    }
}