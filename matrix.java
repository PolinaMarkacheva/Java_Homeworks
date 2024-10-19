//package C:.Users.79200.Desktop
//package com.example;

class ComplexMatrix {
    private Complex[][] matrix;
    private int rows;
    private int cols;

    public ComplexMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new Complex[rows][cols];
    }

    public void setElement(int row, int col, Complex value) {
        matrix[row][col] = value;
    }

    public Complex getElement(int row, int col) {
        return matrix[row][col];
    }

    public ComplexMatrix add(ComplexMatrix other)
    {
        ComplexMatrix result = new ComplexMatrix(rows, cols);
        try {
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    result.setElement(i, j, this.getElement(i, j).add(other.getElement(i, j)));
                }
            }

            }
        catch (IllegalArgumentException E)
        {System.out.print("Matrices must have the same dimensions for addition.");}
        catch (Exception E) {System.out.print("Congratulations! Unknown error. ");}
        return result;
    }

    public ComplexMatrix subtract(ComplexMatrix other) {
        ComplexMatrix result = new ComplexMatrix(rows, cols);
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.setElement(i, j, this.getElement(i, j).subtract(other.getElement(i, j)));
                }
            }
            }
        catch (IllegalArgumentException E) {System.out.print("Matrices must have the same dimensions for subtraction.");}
        catch (Exception E) {System.out.print("Congratulations! Unknown error. ");}
        return result;
    }

    public ComplexMatrix multiply(ComplexMatrix other) {
        ComplexMatrix result = new ComplexMatrix(this.rows, other.cols);
        try
        {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < other.cols; j++) {
                    Complex sum = new Complex(0, 0);
                    for (int k = 0; k < this.cols; k++) {
                        sum = sum.add(this.getElement(i, k).multiply(other.getElement(k, j)));
                    }
                    result.setElement(i, j, sum);
                }
            }
        }
        catch (IllegalArgumentException E) {System.out.print("Invalid matrix dimensions for multiplication.");}
        catch (Exception E) {System.out.print("Congratulations! Unknown error. ");}
        return result;
    }

    public ComplexMatrix transpose() {
        ComplexMatrix result = new ComplexMatrix(this.cols, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setElement(j, i, this.getElement(i, j));
            }
        }
        return result;
    }

    public double determinant() {
            if (rows != cols)
            {
                System.out.print("Determinant can only be calculated for square matrices.");
            }
        return determinant(matrix);
    }

    private double determinant(Complex[][] m) {
        int n = m.length;
        if (n == 1) {
            return m[0][0].getReal(); // Для 1x1 матрицы
        }
        if (n == 2) {
            return m[0][0].getReal() * m[1][1].getReal() - m[0][1].getReal() * m[1][0].getReal(); // Для 2x2 матрицы
        }

        double det = 0;
        for (int p = 0; p < n; p++) {
            Complex[][] subMatrix = new Complex[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < p) {
                        subMatrix[i - 1][j] = m[i][j];
                    } else if (j > p) {
                        subMatrix[i - 1][j - 1] = m[i][j];
                    }
                }
            }
            det += (p % 2 == 0 ? 1 : -1) * m[0][p].getReal() * determinant(subMatrix);
        }
        return det;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Complex[] row : matrix) {
            for (Complex value : row) {
                sb.append(value).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}