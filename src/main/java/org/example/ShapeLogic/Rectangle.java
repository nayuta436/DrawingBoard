package org.example.ShapeLogic;

import java.awt.Graphics;

public class Rectangle extends Shape {
    private static final int X = 50;
    private static final int Y = 50;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    @Override
    public void draw(Graphics g) {
        g.drawRect(X, Y, WIDTH, HEIGHT);
    }

    @Override
    public void erase(Graphics g) {
        g.clearRect(X, Y, WIDTH, HEIGHT);
    }
}
