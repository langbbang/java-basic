package effectivejava.chapter5.sample1;

import java.util.ArrayList;
import java.util.List;

public class Varargs {

    // @SafeVarargs 어노테이션은 재정의할 수 없는 메소드에만 붙일 것
    // 정적 메소드는 재정의가 불가능하므로 사용
    // 하지만 가변인수와 제네릭의 조합은 좋지 않다.
    @SafeVarargs
    public static  <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static  <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        flatten(List.of("1", "2"));

    }
}
