package org.example.Display;

import org.example.ShapeLogic.Circle;
import org.example.ShapeLogic.Rectangle;
import org.example.ShapeLogic.Shape;
import org.example.ShapeLogic.Triangle;
import org.example.ShapeLogic.UnsupportedShapeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class DrawingPanelTest {

    private DrawingPanel drawingPanel;

    @BeforeEach
    void setUp() {
        drawingPanel = new DrawingPanel();
    }

    @Test
    void testSetShapeCircle() throws NoSuchFieldException, IllegalAccessException {
        Shape testShape = new Circle();
        drawingPanel.setShape(testShape);
        Field currentShapeField = drawingPanel.getClass().getDeclaredField("currentShape");
        currentShapeField.setAccessible(true);
        assertEquals(testShape, currentShapeField.get(drawingPanel));
    }

    @Test
    void testSetShapeRectangle() throws NoSuchFieldException, IllegalAccessException {
        Shape testShape = new Rectangle();
        drawingPanel.setShape(testShape);
        Field currentShapeField = drawingPanel.getClass().getDeclaredField("currentShape");
        currentShapeField.setAccessible(true);
        assertEquals(testShape, currentShapeField.get(drawingPanel));
    }

    @Test
    void testSetShapeTriangle() throws NoSuchFieldException, IllegalAccessException {
        Shape testShape = new Triangle();
        drawingPanel.setShape(testShape);
        Field currentShapeField = drawingPanel.getClass().getDeclaredField("currentShape");
        currentShapeField.setAccessible(true);
        assertEquals(testShape, currentShapeField.get(drawingPanel));
    }

    @Test
    void testDrawShapeCircle() {
        Shape testShape = new Circle();
        drawingPanel.setShape(testShape);
        assertDoesNotThrow(() -> drawingPanel.drawShape());
    }

    @Test
    void testDrawShapeRectangle() {
        Shape testShape = new Rectangle();
        drawingPanel.setShape(testShape);
        assertDoesNotThrow(() -> drawingPanel.drawShape());
    }

    @Test
    void testDrawShapeTriangle() {
        Shape testShape = new Triangle();
        drawingPanel.setShape(testShape);
        assertDoesNotThrow(() -> drawingPanel.drawShape());
    }

    @Test
    void testEraseShapeCircle() throws NoSuchFieldException, IllegalAccessException {
        Shape testShape = new Circle();
        drawingPanel.setShape(testShape);
        drawingPanel.eraseShape();
        Field currentShapeField = drawingPanel.getClass().getDeclaredField("currentShape");
        currentShapeField.setAccessible(true);
        assertNull(currentShapeField.get(drawingPanel));
    }

    @Test
    void testEraseShapeRectangle() throws NoSuchFieldException, IllegalAccessException {
        Shape testShape = new Rectangle();
        drawingPanel.setShape(testShape);
        drawingPanel.eraseShape();
        Field currentShapeField = drawingPanel.getClass().getDeclaredField("currentShape");
        currentShapeField.setAccessible(true);
        assertNull(currentShapeField.get(drawingPanel));
    }

    @Test
    void testEraseShapeTriangle() throws NoSuchFieldException, IllegalAccessException {
        Shape testShape = new Triangle();
        drawingPanel.setShape(testShape);
        drawingPanel.eraseShape();
        Field currentShapeField = drawingPanel.getClass().getDeclaredField("currentShape");
        currentShapeField.setAccessible(true);
        assertNull(currentShapeField.get(drawingPanel));
    }

    @Test
    void testUnsupportedShape() {
        assertThrows(UnsupportedShapeException.class, () -> {
            org.example.ShapeLogic.ShapeFactory.createShape("unknown");
        });
    }
}