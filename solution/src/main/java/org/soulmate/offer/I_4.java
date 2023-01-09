package org.soulmate.offer;

public class I_4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int beg = 0, rows = matrix.length - 1, columns = matrix[0].length - 1;
        int[] row;
        while (beg <= rows) {
            row = matrix[beg];
            int rowMax = columns, rowMin = 0, rowMiddle = rowMax / 2;
            while (rowMax >= rowMiddle && rowMin <= rowMiddle) {
                if (target == row[rowMiddle]) {
                    return true;
                } else if (target > row[rowMiddle]) {
                    rowMin = rowMiddle + 1;
                } else if (target < row[rowMiddle]) {
                    rowMax = rowMiddle - 1;
                }
                rowMiddle = (rowMax + rowMin) / 2;
            }
            beg++;
        }

        return false;
    }
}
