package org.soulmate.offer;

public class I_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];

        int row = matrix.length, col = matrix[0].length, len = row * col;
        int[] res = new int[len], lL = new int[2], lH = new int[2], rL = new int[2], rH = new int[2];

        lL[0] = 0;
        lL[1] = 0;

        lH[0] = row - 1;
        lH[1] = 0;

        rL[0] = 0;
        rL[1] = col - 1;

        rH[0] = row - 1;
        rH[1] = col - 1;

        int ptr = 0;
        while (lL[0] <= rH[0] && lL[1] <= rH[1]) {
            int i = lL[0], j = lL[1];
            for (; j <= rL[1] && ptr < len; j++) {
                res[ptr++] = matrix[i][j];
            }

            i = rL[0] + 1;
            j = rL[1];
            for (; i < rH[0] && ptr < len; i++) {
                res[ptr++] = matrix[i][j];
            }

            i = rH[0];
            j = rH[1];
            for (; j >= lH[1] && ptr < len; j--) {
                res[ptr++] = matrix[i][j];
            }

            i = lH[0] - 1;
            j = lH[1];
            for (; i > lL[0] && ptr < len; i--) {
                res[ptr++] = matrix[i][j];
            }
            lL[0]++;
            lL[1]++;
            rH[0]--;
            rH[1]--;

            rL[0]++;
            rL[1]--;
            lH[0]--;
            lH[1]++;
        }

        return res;
    }
}
