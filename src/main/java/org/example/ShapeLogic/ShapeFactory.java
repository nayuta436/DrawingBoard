package org.example.ShapeLogic;

public class ShapeFactory {
    public static Shape createShape(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "triangle":
                return new Triangle();
            default:
                throw new UnsupportedShapeException("不支持的几何形状: " + shapeType);
        }
    }
}
