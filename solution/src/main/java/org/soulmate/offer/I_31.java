package org.soulmate.offer;

import java.util.HashMap;

public class I_31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0)
            return true;

        HashMap<Integer, Integer> hashMap = new HashMap<>(pushed.length);
        for (int i = 0; i < pushed.length; i++) {
            hashMap.put(pushed[i], i);
        }

        boolean[] flag = new boolean[popped.length];
        int prev = hashMap.get(popped[0]);
        flag[prev] = true;

        for (int i = 1; i < popped.length; i++) {
            Integer idx = hashMap.get(popped[i]);
            flag[idx] = true;
            int temp = idx;
            while (++idx <= prev) {
                if (flag[idx] == false)
                    return false;
            }
            prev = temp;
        }

        return true;
    }
}
