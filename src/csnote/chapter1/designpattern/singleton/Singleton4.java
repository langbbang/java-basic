package csnote.chapter1.designpattern.singleton;

/**
 * Lazy Initialization은 이름에 걸맞게, 앞선 두 방식과는 달리 나중에 초기화하는 방법입니다.
 * 이는 global access 한 getInstance() 메소드를 호출할 때에 인스턴스가 없다면 생성합니다.
 * 사용하지 않았을 경우에는 인스턴스가 낭비)에 대해 어느 정도 해결책이 됩니다. 그러나 이 경우에도 문제점이 있습니다.
 * 그건 바로 multi-thread 환경에서 동기화 문제입니다.
 * 만약 인스턴스가 생성되지 않은 시점에서 여러 쓰레드가 동시에 getInstance()를 호출한다면 예상치 못한 결과를 얻을 수 있을뿐더러,
 * 단 하나의 인스턴스를 생성한다는 싱글톤 패턴에 위반하는 문제점이 야기될 수 있습니다.
 * 그렇기에 이 방법으로 구현을 해도 괜찮은 경우는 single-thread 환경이 보장됐을 때입니다.
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}