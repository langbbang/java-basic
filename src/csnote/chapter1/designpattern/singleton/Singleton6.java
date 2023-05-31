package csnote.chapter1.designpattern.singleton;

/**
 * getInstance() 메소드 수준에 lock을 걸지 않고 instance가 null일 경우에만 synchronized가 동작하도록 합니다.
 */
public class Singleton6 {
    private static Singleton6 instance;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}