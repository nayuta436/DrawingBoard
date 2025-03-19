package org.example.Display;

import org.example.ShapeLogic.Shape;
import org.example.ShapeLogic.ShapeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingBoardFrame extends JFrame {
    private JTextField commandField;
    private JButton drawButton;
    private JButton eraseButton;
    private DrawingPanel drawingPanel;

    public DrawingBoardFrame() {
        setTitle("绘图板");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        commandField = new JTextField(20);
        drawButton = new JButton("绘制");
        eraseButton = new JButton("擦除");
        drawingPanel = new DrawingPanel();

        JPanel inputPanel = new JPanel();
        inputPanel.add(commandField);
        inputPanel.add(drawButton);
        inputPanel.add(eraseButton);

        add(inputPanel, BorderLayout.NORTH);
        add(drawingPanel, BorderLayout.CENTER);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDrawCommand();
            }
        });

        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEraseCommand();
            }
        });
    }

    private void handleDrawCommand() {
        String command = commandField.getText();
        try {
            Shape shape = ShapeFactory.createShape(command);
            drawingPanel.setShape(shape);
            drawingPanel.drawShape();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleEraseCommand() {
        drawingPanel.eraseShape();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawingBoardFrame frame = new DrawingBoardFrame();
                frame.setVisible(true);
            }
        });
    }
}
