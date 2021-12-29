package models.elements;

import helpers.constants.Constants;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import models.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Field extends Parent {

    ArrayList<Color> colorList;

    private VBox rows = new VBox();

    public Field(int[][]array, Game game) {
        initColorList();
        createBoard(array, game);
    }

    public Field(int[][]array, Color color, Game game) {
        initColorList();
        createBrokenBoard(array, color, game);
    }

    public void createBoard(int[][]array, Game game) {
        ArrayList<Integer> blockSet = new ArrayList<>();
        Map<Integer, Integer> colors = new HashMap<>();

        for (int y = 0; y < array.length; y++) {
            HBox row = new HBox();
            for (int x = 0; x < array[y].length; x++) {
                Cell cell = new Cell(x, y, this);
                if (!blockSet.contains(array[y][x])) {
                    blockSet.add(array[y][x]);
                }
                cell.setFill(colorList.get(blockSet.indexOf(array[y][x])));
                colors.put(array[y][x], blockSet.indexOf(array[y][x]));
                cell.setStrokeWidth(0.5);
                cell.setStroke(Color.BLACK);
                row.getChildren().add(cell);
            }
            rows.getChildren().add(row);
        }
        game.setColors(colors);
        getChildren().add(rows);
    }

    public void createBrokenBoard(int[][]array, Color color, Game game) {
        ArrayList<Integer> blockSet = new ArrayList<>();

        for (int y = 0; y < array.length; y++) {
            HBox row = new HBox();
            for (int x = 0; x < array[y].length; x++) {
                Cell cell = new Cell(x, y, this);
                if (!blockSet.contains(array[y][x])) {
                    blockSet.add(array[y][x]);
                }

                if (array[y][x] == 0) {
                    cell.setFill(color);
                } else {
                    cell.setFill(colorList.get(blockSet.indexOf(array[y][x])));
                }
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
