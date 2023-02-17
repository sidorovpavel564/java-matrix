package com.example.matrix.module;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Matrix {
    private int rows;
    private int columns;
    private Double[][] matrix;

    public Matrix(int rows, int columns) throws MatrixException {
        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Размеры матрицы не могут быть отрицательными или равными нулю.");
        } else {
            this.rows = rows;
            this.columns = columns;
            this.matrix = new Double[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.matrix[i][j] = 0.0;
                }
            }
        }
    }

    public Matrix(String input) throws MatrixException {
        try {
            // Split the input string into rows
            String[] rows = input.split("], \\[");

            // Remove the first and last square brackets from the first and last rows, respectively
            rows[0] = rows[0].substring(2);
            rows[rows.length - 1] = rows[rows.length - 1].substring(0, rows[rows.length - 1].length() - 2);

            // Split each row into columns (i.e., split on commas)
            Double[][] result = new Double[rows.length][];
            for (int i = 0; i < rows.length; i++) {
                String[] cols = rows[i].split(",");
                result[i] = new Double[cols.length];
                for (int j = 0; j < cols.length; j++) {
                    result[i][j] = Double.parseDouble(cols[j]);
                }
            }

            this.matrix = result;
            this.rows = result.length;
            this.columns = result[0].length;

        } catch (Exception e) {
            System.out.println(e);
            throw new MatrixException("Неверный ввод, проверьте вводимые значения.");
        }
    }

    public void addElementByIndex(int row_index, int column_index, Double element) throws MatrixException {
        if (row_index <= -1 || column_index <= -1) {
            throw new MatrixException("Индексы должны быть положительные.");
        } else if (row_index < this.rows) {
            addRowByIndex(row_index);
            changeElementByIndex(row_index, column_index, element);
        } else if (row_index == this.rows) {
            addRowByIndex(row_index);
            changeElementByIndex(row_index, column_index, element);
        } else if (row_index > this.rows) {
            while (row_index >= this.rows) {
                addRowByIndex(this.rows);
                System.out.println("Row added.");
            }
            changeElementByIndex(row_index, column_index, element);
        }
    }

    public static Matrix parse(String str) throws MatrixException {
        Scanner scanner = new Scanner(str);
        int rows = 0;
        int columns = 0;
        while (scanner.hasNextLine()) {
            rows++;
            String[] line = scanner.nextLine().split(" ");
            if (columns == 0) {
                columns = line.length;
            } else if (line.length != columns) {
                throw new IllegalArgumentException("Invalid matrix format");
            }
        }
        scanner.close();
        scanner = new Scanner(str);
        Matrix matrix = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix.matrix[row][col] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public double get(int row, int column) {
        return matrix[row][column];
    }

    public void set(int row, int column, double value) {
        matrix[row][column] = value;
    }

    public double determinant() throws MatrixException {
        if (rows != columns) {
            throw new IllegalStateException("Matrix is not square");
        }
        if (rows == 1) {
            return matrix[0][0];
        }
        if (rows == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        double det = 0;
        for (int i = 0; i < columns; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * subMatrix(0, i).determinant();
        }
        return det;
    }

    private Matrix subMatrix(int excludingRow, int excludingCol) throws MatrixException {
        Matrix sub = new Matrix(rows - 1, columns - 1);
        int subRow = 0;
        for (int row = 0; row < rows; row++) {
            if (row == excludingRow) {
                continue;
            }
            int subCol = 0;
            for (int col = 0; col < columns; col++) {
                if (col == excludingCol) {
                    continue;
                }
                sub.matrix[subRow][subCol] = matrix[row][col];
                subCol++;
            }
            subRow++;
        }
        return sub;
    }

    public Matrix inverse() throws MatrixException {
        if (rows != columns) {
            throw new IllegalStateException("Matrix is not square");
        }
        double det = determinant();
        if (det == 0) {
            throw new IllegalStateException("Matrix is singular and has no inverse");
        }
        Matrix adjoint = adjoint();
        Matrix inverse = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                inverse.matrix[row][col] = adjoint.matrix[row][col] / det;
            }
        }
        return inverse;
    }

    private Matrix adjoint() throws MatrixException{
        Matrix adjoint = new Matrix(rows, columns);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                adjoint.matrix[col][row] = Math.pow(-1, row + col) * subMatrix(row, col).determinant();
            }
        }
        return adjoint;
    }

    public void fillRndVal() {
        Random random = new Random();
        int low = 5;
        int high = 50;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                double rndmDbl;
                rndmDbl = (random.nextInt(1000)/1000.0 + random.nextInt(high-low));
                this.matrix[i][j] = BigDecimal.valueOf(rndmDbl)
                        .setScale(3, RoundingMode.HALF_UP)
                        .doubleValue();
            }
        }
    }

    public void fillRndDotZero() {
        Random random = new Random();
        int low = 5;
        int high = 50;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j] = ((double) random.nextInt(high - low));
            }
        }
    }

    public void changeElementByIndex(int row_index, int column_index, Double element) throws MatrixException {
        if (row_index >= this.rows || row_index <= -1) {
            throw new MatrixException("changeElementByIndex1\nВведён неверный индекс строки.\n(Счёт индекса строки начинается с 0)");
        } else if (column_index >= this.columns || column_index <= -1) {
            throw new MatrixException("changeElementByIndex2\nВведён неверный индекс колонки.\n(Счёт индекса колонки начинается с 0)");
        } else {
            this.matrix[row_index][column_index] = element;
        }
    }

    public void removeFirstRow()  throws MatrixException{
        if (this.rows <= 0) {
            throw new MatrixException("Матрица уже пустая.");
        } else {
            removeRowByIndex(0);
        }
    }

    public void removeLastRow() throws MatrixException {
        if (this.rows <= 0) {
            throw new MatrixException("Матрица уже пустая");
        } else {
            removeRowByIndex(this.rows - 1);
        }
    }

    public void removeFirstColumn() throws MatrixException {
        if (this.columns <= 0) {
            throw new MatrixException("Матрица уже пустая");
        } else {
            removeColumnByIndex(0);
        }
    }

    public void removeLastColumn() throws MatrixException {
        if (this.columns <= 0) {
            throw new MatrixException("Матрица уже пустая");
        } else {
            removeColumnByIndex(this.columns - 1);
        }
    }

    public void removeRowByIndex(int row_index) throws MatrixException {
        if (row_index > this.rows - 1 || row_index <= -1) {
            throw new MatrixException("Введён неверный индекс строки. (Счёт индекса строки начинается с 0)");
        } else {
            List<Double[]> list1 = new ArrayList<Double[]>(Arrays.asList(this.matrix));
            list1.remove(row_index);
            this.matrix = list1.toArray(new Double[][]{});
            this.rows -= 1;
            if (this.rows == 0) {
                this.columns = 0;
            }
        }
    }

    public void removeColumnByIndex(int column_index) throws MatrixException {
        if (column_index > this.columns - 1 || column_index <= -1) {
            throw new MatrixException("Введён неверный индекс колонки. (Счёт индекса колонки начинается с 0)");
        } else {
            //        Matrix newMatrix = new Matrix(this.rows, this.columns - 1);
            Double[][] newMatrix = new Double[this.rows][this.columns - 1];
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0, col = 0; j < this.columns; j++) {
                    if (j != column_index) {
                        newMatrix[i][col++] = this.matrix[i][j];
//                    newMatrix.matrix[i][col++] = this.matrix[i][j];
                    }
                }
            }
            this.matrix = newMatrix;
            this.columns -= 1;
            if (this.columns == 0) {
                this.rows = 0;
            }
        }
    }

    public void addRowByIndex(int row_index) throws MatrixException {
        if (row_index > this.rows || row_index <= -1) {
            throw new MatrixException("addRowByIndex\nВведён неверный индекс строки. (Счёт индекса строки начинается с 0)");
        } else {
            Double[] addedArray = new Double[this.columns];
            Arrays.fill(addedArray, 0.0);
            List<Double[]> list2 = new ArrayList<Double[]>(Arrays.asList(this.matrix));
            list2.add(row_index, addedArray);
            this.matrix = list2.toArray(new Double[][]{});
            this.rows += 1;
        }
    }

    public void addColumnByIndex(int column_index) throws MatrixException {
        if (column_index > this.columns || column_index <= -1) {
            throw new MatrixException("addColumnByIndex\nВведён неверный индекс колонки. (Счёт индекса колонки начинается с 0)");
        } else {
            Double[][] newMatrix = new Double[this.rows][this.columns + 1];
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0, col = 0; j < this.columns + 1; j++) {
                    if (j == column_index) {
                        newMatrix[i][j] = 0.0;
                    } else {
                        newMatrix[i][j] = this.matrix[i][col++];
                    }
                }
            }
            this.matrix = newMatrix;
            this.columns += 1;
        }
    }

    public static Matrix addition(Matrix matrix1, Matrix matrix2) throws MatrixException {
        if (matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns) {
            throw new MatrixException("Такие матрицы нельзя сложить. Размеры матриц должны совпадать.");
        } else {
            Matrix matrix = new Matrix(matrix1.rows, matrix1.columns);
            for(int i = 0; i < matrix1.rows; i++) {
                for(int j = 0; j < matrix1.columns; j++) {
                    matrix.matrix[i][j] = matrix1.matrix[i][j] + matrix2.matrix[i][j];
                }
            }
            return matrix;
        }
    }

    public static Matrix subtraction(Matrix matrix1, Matrix matrix2) throws MatrixException {
        if (matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns) {
            throw new MatrixException("Такие матрицы нельзя сложить. Размеры матриц должны совпадать.");
        } else {
            Matrix matrix = new Matrix(matrix1.rows, matrix1.columns);
            for(int i = 0; i < matrix1.rows; i++) {
                for(int j = 0; j < matrix1.columns; j++) {
                    matrix.matrix[i][j] = matrix1.matrix[i][j] - matrix2.matrix[i][j];
                }
            }
            return matrix;
        }
    }

    public static Matrix multiplication(Matrix matrix1, Matrix matrix2) throws MatrixException {
        if (matrix1.columns != matrix2.rows) {
            throw new MatrixException("Размеры матриц должны соответсвовать правилам умножения и деления.");
        } else {

            Matrix newMatrix = new Matrix(matrix1.rows, matrix2.columns);

            for(int i = 0; i < matrix1.rows; i++) {
                for(int j = 0; j < matrix2.columns; j++) {
                    for(int k = 0; k < matrix2.rows; k++) {
                        newMatrix.matrix[i][j] += matrix1.matrix[i][k] * matrix2.matrix[k][j];
                    }
                }
            }

            return newMatrix;
        }
    }

    public static Matrix division(Matrix matrix1, Matrix matrix2) throws MatrixException {
        if (matrix2.rows != matrix2.columns) {
            throw new MatrixException("Для деления матриц необходимо, чтобы матрица-делитель была квадратной.");
        } else {
            if (matrix2.determinant() == 0) {
                throw new MatrixException("Определитель матрицы равен нулю.");
            } else {
                return  multiplication(matrix1, matrix2.inverse());
            }
        }
    }

    public void printMatrix() {
        for (Double[] row : this.matrix) {
            // traverses through number of rows
            for (Double element : row) {
                // 'element' has current element of row index
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

//    @Override
//    public String toString() {
//        return Arrays.deepToString(this.matrix);
//    }

    public String matrixToString2() {
        StringBuilder result = new StringBuilder(new String());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.append(BigDecimal.valueOf(this.matrix[i][j])
                        .setScale(5, RoundingMode.HALF_UP)
                        .doubleValue());
                result.append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void showElementByIndex(int row_index, int column_index) {
        double element = this.matrix[row_index][column_index];
        System.out.println(element);
    }
}
