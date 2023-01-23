package org.soulmate.ordinary;

public class P1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int[][] or = new int[row][col];
        int[] cnt = new int[1000001];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && j > 0) {
                    or[i][j] = or[i - 1][j] ^ or[i][j - 1] ^ or[i - 1][j - 1] ^ matrix[i][j];
                } else if (i > 0) {
                    or[i][j] = or[i - 1][j] ^ matrix[i][j];
                } else if (j > 0) {
                    or[i][j] = or[i][j - 1] ^ matrix[i][j];
                } else {
                    or[i][j] = matrix[i][j];
                }
                cnt[or[i][j]]++;
            }
        }

        if (cnt[1000000] >= k)
            return 1000000;

        for (int i = cnt.length - 2; i >= 0; i--) {
            cnt[i] += cnt[i + 1];
            if (cnt[i] >= k) return i;
        }

        return 0;
    }
}
