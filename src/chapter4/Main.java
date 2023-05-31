package chapter4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        // 변경이 가능한 것을 확인할 수 있다.
        // 왜냐하면 객체에서의 final 키워드는 재할당이 불가능한 것이지 값은 변경할 수 있는 것이다.
        SomeThing.things[1] = "1";
        System.out.println(SomeThing.things[1]);
    }
}