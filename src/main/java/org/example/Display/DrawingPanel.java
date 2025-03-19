package org.example.Display;

import org.example.ShapeLogic.Shape;

import javax.swing.*;
import java.awt.*;

// 绘图面板类，属于表示层，负责图形的绘制和擦除操作
public class DrawingPanel extends JPanel {
    private Shape currentShape;

    public void setShape(Shape shape) {
        this.currentShape = shape;
    }

    public void drawShape() {
        if (currentShape != null) {
            repaint();
        }
    }

    public void eraseShape() {
        if (currentShape != null) {
            Graphics g = getGraphics();
            if (g != null) {
                currentShape.erase(g);
                g.dispose();
            }
            currentShape = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentShape != null) {
            currentShape.draw(g);
        }
    }
}
