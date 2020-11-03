public class Shape {
    public enum ShapeOption {
        SQUARE("Square"),
        CIRCLE("Circle"),
        TRIANGLE("Triangle");

        String name;

        ShapeOption(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    String name;
    ShapeOption shapeOption;
    String color;
    int numberOfSides;

    public static void main(String[] args) {
        Shape randomShape = Shape.getRandomShape();
        randomShape.outputData();

        Shape myShape = new Shape("My Shape", ShapeOption.TRIANGLE);
        myShape.outputData();
        myShape.changeShape(ShapeOption.CIRCLE);
        myShape.outputData();
    }

    Shape(String name, ShapeOption shape) {
        System.out.println("Creating shape ... ");
        setShape(name, shape);
    }

    public void outputData() {
        System.out.println("My shape's name is: " + this.name);
        System.out.println("Shape is: " + this.shapeOption);
        System.out.println("It's color is: " + this.color);
        System.out.println("It has " + this.numberOfSides + " sides");
    }

    public void changeShape(ShapeOption newShape) {
        System.out.println("CHANGING SHAPE!");
        setShape(this.name, newShape);
    }

    private void setShape(String name, ShapeOption shape) {
        this.name = name;
        this.shapeOption = shape;
        if (shape.equals(ShapeOption.SQUARE)) {
            this.color = "red";
            this.numberOfSides = 4;
        } else if (shape.equals(ShapeOption.CIRCLE)) {
            this.color = "blue";
            this.numberOfSides = 1;
        } else if (shape.equals(ShapeOption.TRIANGLE)) {
            this.color = "yellow";
            this.numberOfSides = 3;
        }
    }

    public static Shape getRandomShape() {
        return new Shape("Random Shape", ShapeOption.SQUARE);
    }
}
