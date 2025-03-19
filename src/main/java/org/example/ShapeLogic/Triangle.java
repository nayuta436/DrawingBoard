package org.example.ShapeLogic;

import java.awt.Graphics;

// 三角形类，属于业务逻辑层，实现三角形的绘制和擦除逻辑
public class Triangle extends Shape {
    private static final int[] X_POINTS = {50, 100, 150};
    private static final int[] Y_POINTS = {150, 50, 150};
    private static final int N_POINTS = 3;

    @Override
    public void draw(Graphics g) {
        g.drawPolygon(X_POINTS, Y_POINTS, N_POINTS);
    }

    @Override
    public void erase(Graphics g) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < N_POINTS; i++) {
            minX = Math.min(minX, X_POINTS[i]);
            minY = Math.min(minY, Y_POINTS[i]);
            maxX = Math.max(maxX, X_POINTS[i]);
            maxY = Math.max(maxY, Y_POINTS[i]);
        }
        g.clearRect(minX, minY, maxX - minX, maxY - minY);
    }
}
