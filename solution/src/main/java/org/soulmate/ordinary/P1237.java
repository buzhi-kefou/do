package org.soulmate.ordinary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1237 {

    ArrayList<List<Integer>> res = null;

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        res = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            find = false;
            if (customfunction.f(i, 1) <= z || customfunction.f(i, 1000) >= z)
                binarySearch(customfunction, i, 1, 1000, z, true);
        }
        return res;
    }

    boolean find = false;

    void binarySearch(CustomFunction function, int fix, int left, int right, int target, boolean flag) {
        if (!find && left <= right) {
            int middle = (right - left) / 2 + left, val;
            if (flag) {
                val = function.f(fix, middle);
                if (val == target) {
                    res.add(Arrays.asList(new Integer[]{fix, middle}));
                    find = true;
                    return;
                }
            } else {
                val = function.f(middle, fix);
                if (val == target) {
                    res.add(Arrays.asList(new Integer[]{middle, fix}));
                    find = true;
                    return;
                }
            }
            if (val > target) {
                binarySearch(function, fix, left, middle - 1, target, flag);
            } else {
                binarySearch(function, fix, middle + 1, right, target, flag);
            }
        }
    }

    interface CustomFunction {
        // Returns some positive integer f(x, y) for two positive integers x and y based on a formula.
        int f(int x, int y);
    }
}
