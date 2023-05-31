package csnote.chapter1.designpattern.singleton;


/**
 * Eager Initialization은 가장 간단한 형태의 구현 방법입니다.
 * 이는 싱글톤 클래스의 인스턴스를 클래스 로딩 단계에서 생성하는 방법입니다.
 * 그러나 어플리케이션에서 해당 인스턴스를 사용하지 않더라도 인스턴스를 생성하기 때문에 자칫 낭비가 발생할 수 있습니다.
 */
public class Singleton2 {
    private static final Singleton2 instance = new Singleton2();

    // private constructor to avoid client applications to use constructor
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}