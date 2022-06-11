package MultidimensionalArrays.Exc;

import java.util.*;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner.nextLine().split("[()]");

        String text = scanner.nextLine();

        List<String> rowsInput = new ArrayList<>();

        while (!text.equals("END")) {
            rowsInput.add(text);
            text = scanner.nextLine();
        }
        int rows = rowsInput.size();
        int cols = 0;
        for (String row : rowsInput) {
            if (row.length() > cols) {
                cols = row.length();
            }
        }

        char[][] matrix = new char[rows][cols];

        fillInTheMatrix(rowsInput, rows, cols, matrix);

        int angle = Integer.parseInt(command[1]);
        angle %= 360;

        switch (angle) {
            case 0:
                rotate0(rows, cols, matrix);
                break;
            case 90:
                rotate90(rows, cols, matrix);
                break;

            case 180:
                rotate180(rows, cols, matrix);
                break;
            case 270:
                rotate270(rows, cols, matrix);
                break;
        }


    }

    private static void rotate270(int rows, int cols, char[][] matrix) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row ++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }
    }

    private static void rotate180(int rows, int cols, char[][] matrix) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotate90(int rows, int cols, char[][] matrix) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotate0(int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillInTheMatrix(List<String> rowsInput, int rows, int cols, char[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String rowElements = rowsInput.get(row);

                if (col < rowElements.length()) {
                    matrix[row][col] = rowElements.charAt(col);
                } else {
                    matrix[row][col] = 32;
                }
            }
        }
    }
}
