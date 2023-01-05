package org.soulmate.offer;

public class I_44 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }

        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
