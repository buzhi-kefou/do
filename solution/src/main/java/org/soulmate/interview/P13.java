package org.soulmate.interview;

public class P13 {

    public int sum(int r, int c) {
        int sum = 0, div = r, mod = r % 10;
        while (mod != 0 || div != 0) {
            sum += mod;
            div /= 10;
            mod = div % 10;
        }
        div = c;
        mod = c % 10;
        while (mod != 0 || div != 0) {
            sum += mod;
            div /= 10;
            mod = div % 10;
        }
        return sum;
    }

    private int calculate(int a, int b) {
        String s1 = String.valueOf(a), s2 = String.valueOf(b);
        int res = 0;
        for (int i = 0; i < s1.length(); i++)
            res += s1.charAt(i) - '0';
        for (int i = 0; i < s2.length(); i++)
            res += s2.charAt(i) - '0';
        return res;
    }

    public int movingCount(int m, int n, int k) {
        this.cnt = 0;
        this.k = k;

        boolean[][] booleans = new boolean[m][n];
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (!booleans[i][j])
        // dfs(booleans, i, j, m, n);
        // }
        // }

        dfs(booleans, 0, 0, m, n);

        return cnt;
    }

    int k, cnt;

    private void dfs(boolean[][] flag, int i, int j, int m, int n) {
        if (sum(i, j) > k)
            return;
        if ((i == 0 && j == 0) || (i > 0 && flag[i - 1][j]) || (j > 0 && flag[i][j - 1])) {
            flag[i][j] = true;
            cnt++;

            if (i + 1 < m && !flag[i + 1][j])
                dfs(flag, i + 1, j, m, n);
            if (j + 1 < n && !flag[i][j + 1])
                dfs(flag, i, j + 1, m, n);
            if (i - 1 >= 0 && !flag[i - 1][j])
                dfs(flag, i - 1, j, m, n);
            if (j - 1 >= 0 && !flag[i][j - 1])
                dfs(flag, i, j - 1, m, n);
        }
    }
}
