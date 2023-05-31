package csnote.chapter1.designpattern.singleton;

/**
 * private inner static class를 두어 싱글톤 인스턴스를 갖게 합니다.
 * SingletonInstanceHolder 클래스는 Singleton 클래스가 Load 될 때에도 Load 되지 않다가
 * getInstance()가 호출됐을 때 비로소 JVM 메모리에 로드되고, 인스턴스를 생성하게 됩니다.
 * 아울러 synchronized를 사용하지 않기 때문에 4번에서 문제가 되었던 성능 저하 또한 해결됩니다.
 */

/**
 * 클래스 로더가 어떻게 클래스를 동적으로 로딩하는지?
 * <p>
 * 클래스를 메모리에 올리는 Loading 기능은 한번에 메모리에 올리지 않고, 어플리케이션에서 필요한 경우 동적으로 메모리에 적재하게 된다는 점이다.
 * 사람들이 많이들 착각하는 점이 위의 3가지 과정이 거의 동시에 이루어져서 같이 묶어 생각하는데,
 * 엄연히 클래스 로드(Loading)와 초기화(Initialization)은 다른 작업이다.
 * 그리고 클래스나 클래스 내의 static 멤버들을 소스를 실행하자마자 한번에 메모리에 모두 올라가는줄 착각하는데,
 * 곰곰히 생각해보면 언제 어디서 사용될지 모르는 static 멤버들을 처음에 전부 메모리에 올린다는건 비효율적이기 때문에,
 * 클래스 내의 멤버를 호출하게 되면 그때서야 클래스가 동적으로 메모리에 로드된다.
 * 즉, JVM은 실행될때 모든 클래스를 메모리에 올려놓지 않고, 그때 마다 필요한 클래스를 메모리에 올려 효율적으로 관리하는 것이다.
 *
 * https://inpa.tistory.com/entry/JAVA-%E2%98%95-%ED%81%B4%EB%9E%98%EC%8A%A4%EB%8A%94-%EC%96%B8%EC%A0%9C-%EB%A9%94%EB%AA%A8%EB%A6%AC%EC%97%90-%EB%A1%9C%EB%94%A9-%EC%B4%88%EA%B8%B0%ED%99%94-%EB%90%98%EB%8A%94%EA%B0%80-%E2%9D%93
 */
public class Singleton {
    private static class SingletonInstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingletonInstanceHolder.INSTANCE;
    }
}
