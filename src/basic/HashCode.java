package basic;

public class HashCode {
    public static void main(String[] args) {

        String str = "가나다라"; // 리터럴 이용한 방식 -> Heap 영역 안에 String 상수 저장 pool 있음, String Constant Pool
        String str2 = new String("가나다라"); // new 연산자를 통해 생성
        String str3 = new String("가나다라");
        String str4 = "가나다라";

        System.out.println(str.hashCode()); // 1356668848
        System.out.println(str2.hashCode()); // 1356668848
        System.out.println(str3.hashCode()); // 1356668848
        System.out.println(str4.hashCode()); // 1356668848

        System.out.println(str.equals(str2)); // true

        System.out.println(str == str2); // false
        System.out.println(str == str4); // true
        System.out.println(str2 == str3); // false
    }
}
