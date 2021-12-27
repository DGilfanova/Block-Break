package helpers.handlers;

import exceptions.WrongResponseMessageException;

public class GameStateHandler {

    public static int[][] processStartBlock(int [][] x, int[][] y) {
        if (x.length == y.length) {
            int[][] newArray = new int[x.length][y.length];
            for (int i = 0; i < x.length; i++) {
                newArray[x[i][0]][y[i][0]] = x[i][1];
            }
            return newArray;
        } else {
            throw new WrongResponseMessageException("Wrong server parameter");
        }
    }

    public static void main(String[] args) {
        int [][] x = new int[][]{{0,15},{0, 16}, {1,16}, {1,25}};
        int [][] y = new int[][]{{0,15},{1, 16}, {0,16}, {1,25}};
        int [][] a = processStartBlock(x, y);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
