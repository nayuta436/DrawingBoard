package org.example.ShapeLogic;

// 自定义异常类，处理不支持的形状类型
public class UnsupportedShapeException extends RuntimeException {
    public UnsupportedShapeException(String message) {
        super(message);
    }
}
