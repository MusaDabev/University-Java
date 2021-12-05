package com.dabevstuff.FirstTask;

import java.util.Random;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        int rows = generateRandomNum();
        int columns = generateRandomNum();

        String[][] matrix = new String[rows][columns];

        printMatrix(matrix);
        printMatrixDiagonals(matrix);
    }

    private static List<String> getDiagonal(int x, int y, int rows, int cols, String[][] matrix) {
        List<String> diag = new ArrayList<>();

        while (x < rows && y < cols) {
            diag.add(matrix[x++][y++]);
        }

        return diag;
    }

    private static void printMatrixDiagonals(String[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

         List<List<String>>diags = new ArrayList<>();

        for (int r = rows - 1; r > 1; --r) {
            diags.add(getDiagonal(r, 0, rows, cols, matrix));
        }

        for (int c = 0; c < cols; ++c) {
            diags.add(getDiagonal(0, c, rows, cols, matrix));
        }

        for (int i = diags.size() - 1; i >= 0; i--) {
            System.out.print(String.join(" ", diags.get(i)));

            printIndexIfSymbolsAreEqual(diags.get(i), diags.size() - i);
            System.out.println();
        }
    }

    private static void printIndexIfSymbolsAreEqual(List<String> symbols, int index) {
        HashSet<String> s = new HashSet<String>(symbols);

        if (s.size() != symbols.size()) {
            System.out.print(index);
        }
    }

    private static void printMatrix(String[][] myArray) {
        int rows = myArray.length;
        int cols = myArray[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                myArray[i][j] = generateRandomLetter();
                System.out.print(myArray[i][j] + "\t");
            }

            System.out.println();
        }

        System.out.println("================================");
    }

    public static int generateRandomNum() {
        int randomNumber = new Random().nextInt(15) + 1;

        return randomNumber;
    }

    public static String generateRandomLetter() {
        int randomNum = new Random().nextInt(4);

        switch (randomNum) {
            case 0:
                return "'ф'";
            case 1:
                return "'х'";
            case 2:
                return "'ц'";
            default:
                return "'ч'";
        }
    }
}