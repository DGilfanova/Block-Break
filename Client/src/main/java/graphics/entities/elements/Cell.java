package graphics.entities.elements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    private static final int width = 30;
    private static final int height = 30;

    private static final Color defaultColor = Color.WHITE;
    private static final Color hoverColor = Color.GRAY;

    private int x,y;

    public Cell(int x, int y, Field field) {
        super(width, height);
        this.x = x;
        this.y = y;
    }
}
