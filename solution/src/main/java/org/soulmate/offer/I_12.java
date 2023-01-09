package org.soulmate.offer;

public class I_12 {
    boolean res = false;

    public boolean exist(char[][] board, String word) {
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                func(flag, board, i, j, word, 0);
                if (res)
                    break;
            }
        }
        return res;
    }

    public void func(boolean[][] flag, char[][] board, int row, int col, String str, int ptr) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || flag[row][col])
            return;
        if (board[row][col] != str.charAt(ptr))
            return;
        if (++ptr == str.length()) {
            res = true;
            return;
        }
        flag[row][col] = true;
        func(flag, board, row + 1, col, str, ptr);
        if (res)
            return;
        func(flag, board, row - 1, col, str, ptr);
        if (res)
            return;
        func(flag, board, row, col + 1, str, ptr);
        if (res)
            return;
        func(flag, board, row, col - 1, str, ptr);
        flag[row][col] = false;
    }
}
