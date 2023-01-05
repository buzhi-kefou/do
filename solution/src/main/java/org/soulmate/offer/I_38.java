package org.soulmate.offer;

import java.util.ArrayList;

public class I_38 {
    ArrayList<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        char[] item = new char[chars.length];
        boolean[] flag = new boolean[chars.length];

        deal(chars, item, flag, 0);

        return list.toArray(new String[0]);
    }

    private void deal(char[] array, char[] item, boolean[] flag, int idx) {
        if (idx == array.length) {
            list.add(String.valueOf(item));
            return;
        }
        int[] curr = new int[128];
        for (int i = 0; i < array.length; i++) {
            if (flag[i] || curr[array[i]] == 1)
                continue;
            flag[i] = true;
            curr[array[i]] = 1;
            item[idx] = array[i];
            deal(array, item, flag, idx + 1);
            flag[i] = false;
        }
    }
}
