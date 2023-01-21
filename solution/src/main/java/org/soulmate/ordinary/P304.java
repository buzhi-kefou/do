package org.soulmate.ordinary;

public class P304 {

    static class NumMatrix {

        int[][] sum;
        int row, col;

        public NumMatrix(int[][] matrix) {
            row = matrix.length;
            col = matrix[0].length;
            sum = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sum[i][j] = matrix[i][j];
                    if (i > 0)
                        sum[i][j] += sum[i - 1][j];
                    if (j > 0)
                        sum[i][j] += sum[i][j - 1];
                    if (i > 0 && j > 0)
                        sum[i][j] -= sum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 > 0 && col1 > 0)
                return sum[row2][col2] + sum[row1 - 1][col1 - 1] - sum[row1 - 1][col2] - sum[row2][col1 - 1];
            else if (row1 > 0)
                return sum[row2][col2] - sum[row1 - 1][col2];
            else if (col1 > 0)
                return sum[row2][col2] - sum[row2][col1 - 1];
            else return sum[row2][col2];
        }
    }
}
