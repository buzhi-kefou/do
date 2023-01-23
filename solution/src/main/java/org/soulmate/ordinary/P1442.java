package org.soulmate.ordinary;

public class P1442 {

    public int countTriplets(int[] arr) {
        int len = arr.length;
        int[] prefix = new int[len];
        prefix[0] = arr[0];
        for (int i = 1, j = 0; i < len; i++, j++) {
            prefix[i] = prefix[j] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (i == 0) {
                    if (prefix[j] == 0)
                        count += j;
                } else if ((prefix[j] ^ prefix[i - 1]) == 0) {
                    count += (j - i);
                }
            }
        }

        return count;
    }
}
