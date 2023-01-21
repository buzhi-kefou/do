package org.soulmate.ordinary;

public class P1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length, col = mat[0].length;

        int[][] sum = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i][j] = mat[i][j];
                if (i > 0 && j > 0) {
                    sum[i][j] -= sum[i - 1][j - 1];
                    sum[i][j] += sum[i - 1][j];
                    sum[i][j] += sum[i][j - 1];
                } else if (i > 0) {
                    sum[i][j] += sum[i - 1][j];
                } else if (j > 0) {
                    sum[i][j] += sum[i][j - 1];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int len = Math.min(i, j) + 1;
                for (int k = max + 1; k <= len; k++) {
                    int a = i - k, b = j - k, temp;
                    if (a < 0 && b < 0) {
                        temp = sum[i][j];
                    } else if (a < 0) {
                        temp = sum[i][j] - sum[i][b];
                    } else if (b < 0) {
                        temp = sum[i][j] - sum[a][j];
                    } else {
                        temp = sum[i][j] - sum[i][b] - sum[a][j] + sum[a][b];
                    }
                    if (temp > threshold) break;
                    if (max < k) max = k;
                }
            }
        }

        return max;
    }
}
