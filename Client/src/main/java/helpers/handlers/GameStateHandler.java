package helpers.handlers;

import exceptions.WrongResponseMessageException;
import helpers.constants.Constants;
import models.Game;
import models.characters.AbstractCharacter;

import java.util.ArrayList;
import java.util.List;

public class GameStateHandler {

    public static int[][] processStartBlock(int [][] x, int[][] y) {
        if (x.length == y.length) {
            int[][] newArray = new int[Constants.FIELD_WIDTH][Constants.FIELD_HEIGHT];
            for (int i = 0; i < x.length; i++) {
                newArray[x[i][0]][y[i][0]] = x[i][1];
            }
            return newArray;
        } else {
            throw new WrongResponseMessageException("Wrong server parameter");
        }
    }

    public static ArrayList<AbstractCharacter> processCharacters(int [][] x, Game game) {
        List<Long> charIds = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            charIds.add((long) x[i][0]);
        }

        List<AbstractCharacter> characters = game.getCharacters();
        ArrayList<AbstractCharacter> chosenCharacters = new ArrayList<>();
        for (Long c: charIds) {
            for (AbstractCharacter character: characters) {
                if (character.getId() == c) {
                    chosenCharacters.add(character);
                }
            }
        }

        return chosenCharacters;
    }

    public static ArrayList<AbstractCharacter> processStartCharacters(int [] x, Game game) {
        List<AbstractCharacter> characters = game.getCharacters();
        ArrayList<AbstractCharacter> chosenCharacters = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            for (AbstractCharacter character: characters) {
                if (character.getId() == x[i]) {
                    chosenCharacters.add(character);
                }
            }
        }

        return chosenCharacters;
    }

    //id = 0 -> ячейка уже разбита
    public static int[][] processBlockState(int [][] blockState, int [][] startBlock) {
        int[][] newArray = new int[Constants.FIELD_WIDTH][Constants.FIELD_HEIGHT];

        for (int i = 0; i < startBlock.length; i++) {
            for (int j = 0; j < startBlock.length; j++) {
                for (int z = 0; z < blockState.length; z++) {
                    if (blockState[z][0] == startBlock[i][j]) {
                        if (blockState[z][1] == 0) {
                            newArray[i][j] = 0;
                        } else {
                            newArray[i][j] = blockState[z][0];
                        }
                    }
                }
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int [][] x = new int[][]{{0,15},{0, 16}, {1,16}, {1,25}};
        int [][] y = new int[][]{{0,15},{1, 16}, {0,16}, {1,25}};
        int [][] b = new int[][]{{15,250},{16, 0}, {25,254}};
        int [][] n = processStartBlock(x, y);
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }

        int [][] a = processBlockState(b, n);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
