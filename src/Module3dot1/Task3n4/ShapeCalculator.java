package Module3dot1.Task3n4;

class Shape {
    protected String type;
    protected double height;
    protected double width;

    public Shape(double height, double width) {
        this.height = height;
        this.width = width;
    }


    public double calculateArea() {
        return height * width;
    }
}

class Circle extends Shape {
    private String color;

    public Circle(double height, double width, String color) {
        super(height, width);
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + " Circle with a radius of " + super.height + " has an Area of " + calculateArea();
    }

    @Override
    public double calculateArea() {
        double division = super.height / 2.0;
        return Math.pow(division, 2) * Math.PI;
    }
}

class Triangle extends Shape {
    private String color;

    public Triangle(double height, double width, String color) {
        super(height, width);
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + " Triangle with a width of " + super.width + " and a height of " + super.height + " has an Area of " + calculateArea();
    }

    @Override
    public double calculateArea() {
        return super.calculateArea() / 2.0;
    }
}

class Square extends Shape {
    private String color;

    public Square(double height, double width,  String color) {
        super(height, width);
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color + " Square with a width of " + super.width + " and a height of " + super.height + " has an Area of " + calculateArea();
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        System.out.println(new Square( 3.0, 6.0, "Yellow"));
        System.out.println(new Triangle( 4.0, 6.0, "Blue"));
        System.out.println(new Circle( 4.0, 0, "Red"));
    }
}
