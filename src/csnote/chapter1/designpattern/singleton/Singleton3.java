package csnote.chapter1.designpattern.singleton;

/**
 * 싱글톤 클래스의 인스턴스를 생성할 때 발생할 수 있는 예외에 대한 처리를 할 수 있지만,
 * Eager Initialization과 마찬가지로 클래스 로딩 단계에서 인스턴스를 생성하기 때문에
 * 여전히 큰 리소스를 다루는 경우에는 적합하지 않게 됩니다.
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    //static block initialization for exception handling
    static {
        try {
            instance = new Singleton3();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}