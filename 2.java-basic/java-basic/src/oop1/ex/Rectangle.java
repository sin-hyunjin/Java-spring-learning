package oop1.ex;

public class Rectangle {

    int width;
    int height;

    // 넓이
    int calculateArea() {
        return width * height;
    }

    // 둘레 길이
    int calculatePerimeter() {
        return 2 * (width + height);
    }
    // 정사각형 여부
    boolean isSquare() {
        return width == height;
    }
}
