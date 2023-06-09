package effectivejava.chapter4.sample2.before;

/**
 * 리펙토링 예제 - bad case
 * 문제점 : Figure 클래스 안에 원형 타입이라면 사용하지 않을 필드와
 * 반대로 사각형 타입이라면 사용하지 않을 필드가 혼재해있다.
 * 그리고 쓸데 없이 타입 구분을 위한 switch 문까지 더해서 가독성도 나쁘다.
 */
public class Figure {
    enum Shape {RECTANGLE, CIRCLE}

    final Shape shape;

    double length;
    double width;

    double radius;

    // 원형 전용 생성자
    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형 전용 생성자
    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        return switch (shape) {
            case RECTANGLE -> length * width;
            case CIRCLE -> Math.PI * radius * radius;
            default -> throw new AssertionError(shape);
        };
    }
}
