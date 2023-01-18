package org.soulmate.ordinary;

public class P2067 {

    public int equalCountSubstrings(String s, int count) {
        int[][] matrix = new int[26][s.length()];
        int min = 26, max = 0, ptr = s.charAt(0) - 'a';
        if (ptr < min) min = ptr;
        if (ptr >= max) max = ptr;
        matrix[ptr][0] = 1;

        for (int i = 1; i < matrix[0].length; i++) {
            ptr = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++)
                matrix[j][i] = matrix[j][i - 1];
            matrix[ptr][i] += 1;
            if (ptr < min) min = ptr;
            if (ptr >= max) max = ptr;
        }

        int len = count, res = 0;
        while (len <= matrix[0].length) {
            len--;
            for (int i = 0; i + len < matrix[0].length; i++) {
                ptr = i + len;
                int cnt = -1;
                if (i > 0) {
                    i--;
                    for (int j = min; j <= max; j++) {
                        cnt = matrix[j][ptr] - matrix[j][i];
                        if (cnt != 0 && cnt != count)
                            break;
                    }
                    i++;
                } else {
                    for (int j = min; j <= max; j++) {
                        cnt = matrix[j][ptr];
                        if (cnt != 0 && cnt != count)
                            break;
                    }
                }
                if (cnt == 0 || cnt == count)
                    res++;
            }
            len++;
            len += count;
        }
        return res;
    }
}
