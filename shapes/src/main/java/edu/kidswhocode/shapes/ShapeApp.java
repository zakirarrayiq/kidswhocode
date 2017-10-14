package edu.kidswhocode.shapes;

/**
 * HelloWorldApp.
 *
 * @author Zakir Magdum
 */
public class ShapeApp {
    public static void main(String[] args) {
        Circle circle = new Circle(12, 10, 10, "red");
        Rectangle rectangle = new Rectangle(7, 5, 20, 33, "blue");
        Square square = new Square(8, 12, 16, "green");
        Triangle triangle = new Triangle(16, 8, 44, 23, "yellow");

        System.out.println("Shape " + circle);
        System.out.println("Shape " + rectangle);
        System.out.println("Shape " + square);
        System.out.println("Shape " + triangle);

        System.out.println("Scaled Circle area " + circle.area(10));
        System.out.println("Scaled Rectangle area " + rectangle.area(10));
        System.out.println("Scaled Square area " + square.area(10));
        System.out.println("Scaled Triangle area " + triangle.area(10));
    }
}
