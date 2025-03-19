package org.example.ShapeLogic;

import java.awt.Graphics;

// 圆形类，属于业务逻辑层，实现圆形的绘制和擦除逻辑
public class Circle extends Shape {
    private static final int X = 50;
    private static final int Y = 50;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    @Override
    public void draw(Graphics g) {
        g.drawOval(X, Y, WIDTH, HEIGHT);
    }

    @Override
    public void erase(Graphics g) {
        g.clearRect(X, Y, WIDTH, HEIGHT);
    }
}
