package effectivejava.chapter4.sample1;


/**
 * 불변 클래스 특징
 * plus() 함수를 보면 값을 더해 새로운 객체로 리턴하는 특징을 볼 수 있다.
 * 원래의 인스턴스 값을 변경하지 않는다.
 */
public final class Point {
    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 정적 펙토리 메소드
    public static Point valueOf(int x, int y) {
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point plus(Point point) {
        return new Point(x + point.x, y + point.y);
    }

    public Point minus(Point point) {
        return new Point(x - point.x, y - point.y);
    }
}
