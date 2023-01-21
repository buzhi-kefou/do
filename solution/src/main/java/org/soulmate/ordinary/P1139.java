package org.soulmate.ordinary;

public class P1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] rowPrefix = new int[row][col];
        int[][] colPrefix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0)
                    colPrefix[i][j] = grid[i][j];
                else
                    colPrefix[i][j] = colPrefix[i - 1][j] + grid[i][j];

                if (j == 0)
                    rowPrefix[i][j] = grid[i][j];
                else
                    rowPrefix[i][j] = rowPrefix[i][j - 1] + grid[i][j];
            }
        }

        int len = 0, max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int min = Math.min(i, j) + 1;
                for (int k = len + 1; k <= min; k++) {
                    int a = i - k, b = j - k;
                    boolean flag = false;
                    if (a >= 0 && b >= 0) {
                        if ((rowPrefix[i][j] - rowPrefix[i][b] == k) && (rowPrefix[a + 1][j] - rowPrefix[a + 1][b] == k) &&
                                (colPrefix[i][j] - colPrefix[a][j] == k) && (colPrefix[i][b + 1] - colPrefix[a][b + 1] == k))
                            flag = true;
                    } else if (a >= 0 && b < 0) {
                        if ((rowPrefix[i][j] == k) && (rowPrefix[a + 1][j] == k) &&
                                (colPrefix[i][j] - colPrefix[a][j] == k) && (colPrefix[i][0] - colPrefix[a][0] == k))
                            flag = true;
                    } else if (b >= 0 && a < 0) {
                        if ((rowPrefix[i][j] - rowPrefix[i][b] == k) && (rowPrefix[0][j] - rowPrefix[0][b] == k) &&
                                (colPrefix[i][j] == k && colPrefix[i][b + 1] == k))
                            flag = true;
                    } else if ((rowPrefix[i][j] == k && colPrefix[i][j] == k) && rowPrefix[0][j] == k && colPrefix[i][0] == k) {
                        flag = true;
                    }
                    if (flag && max < k) {
                        max = k;
                        len = k;
                    }
                }
            }
        }

        return max * max;
    }

}
