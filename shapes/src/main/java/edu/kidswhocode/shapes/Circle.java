package edu.kidswhocode.shapes;

/**
 * Circle.
 *
 * @author Zakir Magdum
 */
public class Circle extends Shape {
    private static final double PI = 3.14;

    private int radius;

    public Circle(int radius, int x, int y, String color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    double area() {
        return PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                super.toString() +
                '}';
    }

}
