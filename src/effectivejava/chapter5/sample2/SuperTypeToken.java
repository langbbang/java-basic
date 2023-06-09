package effectivejava.chapter5.sample2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * **** 슈퍼 타입 토큰의 필요성에 대한 배경 ****
 *
 * Map<Class<?>, Object> m = new HashMap<>();
 * m.put(List.class, Arrays.asList(1,2,3));
 * m.put(List.class, Arrays.asList("a", "b", "c")); // 덮어씌움
 *
 * 같은 List 타입이라 덮어씌워지게 된다.
 *
 * 그래서 아래와 같은 방식으로 하면 될 거 같지만 컴파일 에러가 발생한다.
 * m.put(List<Integer>.class, Arrays.asList(1,2,3));
 * m.put(List<String>.class, Arrays.asList("a", "b", "c"));
 *
 * 클래스 리터럴(.class)로 List<Integer> 에 대한 클래스 오브젝트를 가져올 때 타입 파라미터 적용한거를 구분해서 가져올 수 없다.
 * Class 타입에는 제네릭 타입 파라미터에 대한 정보가 없다.
 *
 * 이 문제는 스프링 restTemplate에서 Http response body 정보를 자바 객체로 컨버팅 할 때도 발생한다.
 */
public class SuperTypeToken {

    static class TypeSafeMap {
        Map<TypeReference<?>, Object> map = new HashMap<>();

        <T> void put(TypeReference<T> tr, T value) {
            map.put(tr, value);
        }

        <T> T get(TypeReference<T> tr) {
            if (tr.type instanceof Class<?>)
                return ((Class<T>) tr.type).cast(map.get(tr));
            else
                return ((Class<T>) ((ParameterizedType) tr.type).getRawType()).cast(map.get(tr));
        }
    }

    static class TypeReference<T> {
        Type type;

        public TypeReference() {
            Type sType = getClass().getGenericSuperclass();
            if (sType instanceof ParameterizedType) {
                this.type = ((ParameterizedType) sType).getActualTypeArguments()[0];
            } else {
                throw new RuntimeException();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
            TypeReference<?> that = (TypeReference<?>) o;
            return type.equals(that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }
    }

    public static void main(String[] args) throws Exception {
        TypeSafeMap m = new TypeSafeMap();
        m.put(new TypeReference<String>() {}, "String");
        m.put(new TypeReference<Integer>() {}, 1);

        m.put(new TypeReference<List<Integer>>() {}, Arrays.asList(1, 2, 3));
        m.put(new TypeReference<List<String>>() {}, Arrays.asList("a", "b", "c"));

        System.out.println(m.get(new TypeReference<String>() {}));
        System.out.println(m.get(new TypeReference<Integer>() {}));
        System.out.println(m.get(new TypeReference<List<Integer>>() {}));
        System.out.println(m.get(new TypeReference<List<String>>() {}));
    }
}