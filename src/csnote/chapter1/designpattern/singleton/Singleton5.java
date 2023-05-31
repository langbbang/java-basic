package csnote.chapter1.designpattern.singleton;

/**
 * getInstance() 메소드 내에 진입하는 쓰레드가 하나로 보장받기 때문에 멀티 쓰레드 환경에서도 정상 동작하게 됩니다.
 * 그러나 synchronized 키워드 자체에 대한 비용이 크기 때문에 싱글톤 인스턴스 호출이 잦은 어플리케이션에서는 성능이 떨어지게 됩니다.
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5(){}

    public static synchronized Singleton5 getInstance(){
        if(instance == null){
            instance = new Singleton5();
        }
        return instance;
    }

}