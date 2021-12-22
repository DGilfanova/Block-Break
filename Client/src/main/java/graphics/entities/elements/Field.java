package graphics.entities.elements;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Field extends Parent {

    //заполнить цветами
    ArrayList<Color> colorList;

    private final static int xSize = 4;
    private final static int ySize = 4;

    private VBox rows = new VBox();
    private boolean enemy = false;

    public Field(int[][]array) {
        initColorList();
        createBoard(array);
    }

    public void initColorList() {
        colorList = new ArrayList<>();
        colorList.add(Color.YELLOW);
        colorList.add(Color.CORAL);
        colorList.add(Color.BLUEVIOLET);
        colorList.add(Color.MAGENTA);
    }

    public void createBoard(int[][]array) {
        ArrayList<Integer> blockSet = new ArrayList<>();

        for (int y = 0; y < array.length; y++) {
            HBox row = new HBox();
            for (int x = 0; x < array[y].length; x++) {
                Cell cell = new Cell(x, y, this);
                if (!blockSet.contains(array[y][x])) {
                    blockSet.add(array[y][x]);
                }
                cell.setFill(colorList.get(blockSet.indexOf(array[y][x])));
                cell.setStrokeWidth(0.5);
                cell.setStroke(Color.BLACK);
                row.getChildren().add(cell);
            }
            rows.getChildren().add(row);
        }
        getChildren().add(rows);
    }

    public Cell getCell(int x, int y) {
        return (Cell)((HBox)(rows.getChildren().get(y))).getChildren().get(x);
    }

    //возвращается снова двумерный массив??
    public void shoot(Character character, int x, int y) {
    }
}
