package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    private final List<String> strings = new ArrayList<>();

    public void 객체_필드는_final_이어도_내용물_값_변경이_가능하다() {
        //가능 (객체 필드(속성)는 변경이 가능함)
        strings.add("AAA");
        strings.add("BBB");
        strings.set(0, "CCC");

        //불가능 (다른 객체로 변경 할 수 없음 = 참조값 변경 불가)
//        strings = new ArrayList<>();
    }

}