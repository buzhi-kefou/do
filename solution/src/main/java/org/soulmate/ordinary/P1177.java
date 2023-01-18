package org.soulmate.ordinary;

import java.util.ArrayList;
import java.util.List;

public class P1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] count = new int[26][s.length()];
        count[s.charAt(0) - 'a'][0] = 1;

        for (int i = 1; i < count[0].length; i++) {
            for (int j = 0; j < 26; j++)
                count[j][i] = count[j][i - 1];
            int ptr = s.charAt(i) - 'a';
            count[ptr][i] += 1;
        }

        ArrayList<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int odd = 0, left = queries[i][0], right = queries[i][1], k = queries[i][2];
            if (left > 0) {
                left--;
                for (int j = 0; j < 26; j++) {
                    if ((count[j][right] - count[j][left]) % 2 == 1)
                        odd++;
                }
                left++;
            } else {
                for (int j = 0; j < 26; j++) {
                    if (count[j][right] % 2 == 1)
                        odd++;
                }
            }
            odd -= (k * 2);
            if (odd > 1 || (odd == 1 && (right - left) % 2 == 1)) {
                res.add(false);
            } else {
                res.add(true);
            }
        }
        return res;
    }
}
