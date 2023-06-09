package effectivejava.chapter4.sample1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SomeThing {
    // 내용물 값 변경 가능
    public final static String[] things = {"a", "b", "c"};

    private final static String[] things2 = {"a", "b", "c", "d"};

    // clone() 을 사용하여 public한 함수를 제공한다.
    public static final String[] getByClone() {
        return things2.clone();
    }

    public static final List<String> getByCollections() {
        return Collections.unmodifiableList(Arrays.asList(things2));
    }
}
