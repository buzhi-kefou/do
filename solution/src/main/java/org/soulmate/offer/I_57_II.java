package org.soulmate.offer;

import java.util.ArrayList;

public class I_57_II {

//    public int[][] findContinuousSequence(int target) {
//        List<int[]> vec = new ArrayList<int[]>();
//        for (int l = 1, r = 2; l < r; ) {
//            int sum = (l + r) * (r - l + 1) / 2;
//            if (sum == target) {
//                int[] res = new int[r - l + 1];
//                for (int i = l; i <= r; ++i) {
//                    res[i - l] = i;
//                }
//                vec.add(res);
//                l++;
//            } else if (sum < target) {
//                r++;
//            } else {
//                l++;
//            }
//        }
//        return vec.toArray(new int[vec.size()][]);
//    }

    public int[][] findContinuousSequence(int target) {
        int mid = target / 2;
        if (target % 2 == 1)
            mid++;

        for (int i = 1; i <= mid; i++) {
            func(i, i, i + 1, target);
        }

        return list.toArray(new int[list.size()][]);
    }

    ArrayList<int[]> list = new ArrayList<>();

    //tmp当前和 beg最小值 pos当前值 max最大值
    private void func(int tmp, int beg, int pos, int target) {
        if (tmp == target) {
            int[] array = new int[pos - beg];
            for (int i = pos - 1, j = array.length - 1; i >= beg; i--, j--) {
                array[j] = i;
            }
            list.add(array);
            return;
        }

        if (tmp + pos <= target)
            func(tmp + pos, beg, pos + 1, target);
    }
}
