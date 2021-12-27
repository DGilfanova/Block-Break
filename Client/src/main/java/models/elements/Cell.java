package models.elements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    private static final int width = 50;
    private static final int height = 50;

    private static final Color blockedColor = Color.BLACK;
    private static final Color hoverColor = Color.GRAY;

    private int x,y;

    public Cell(int x, int y, Field field) {
        super(width, height);
        this.x = x;
        this.y = y;
    }
}
