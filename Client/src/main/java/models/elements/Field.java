package models.elements;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Field extends Parent {

    ArrayList<Color> colorList;

    private final static int xSize = 8;
    private final static int ySize = 8;

    private VBox rows = new VBox();

    public Field(int[][]array) {
        initColorList();
        createBoard(array);
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

    public void initColorList() {
        colorList = new ArrayList<>();
        colorList.add(Color.YELLOW);
        colorList.add(Color.CORAL);
        colorList.add(Color.BLUEVIOLET);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.MAROON);
        colorList.add(Color.MEDIUMVIOLETRED);
        colorList.add(Color.LIME);
        colorList.add(Color.LIGHTGRAY);
        colorList.add(Color.LIGHTSALMON);
        colorList.add(Color.INDIGO);
        colorList.add(Color.LAVENDER);
        colorList.add(Color.KHAKI);
        colorList.add(Color.IVORY);
        colorList.add(Color.LEMONCHIFFON);
        colorList.add(Color.LIGHTCYAN);
        colorList.add(Color.MEDIUMSEAGREEN);
        colorList.add(Color.MINTCREAM);
        colorList.add(Color.MIDNIGHTBLUE);
        colorList.add(Color.OLIVE);
        colorList.add(Color.MOCCASIN);
        colorList.add(Color.PALEGOLDENROD);
        colorList.add(Color.NAVY);
        colorList.add(Color.PEACHPUFF);
    }

    public Cell getCell(int x, int y) {
        return (Cell)((HBox)(rows.getChildren().get(y))).getChildren().get(x);
    }
}
