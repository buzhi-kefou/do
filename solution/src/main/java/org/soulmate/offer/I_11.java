package org.soulmate.offer;

public class I_11 {

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        int k = j / 2;

        while (i < j) {
            if (numbers[k] == numbers[j]) {
                j -= 1;
            }
            if (numbers[k] < numbers[j]) {
                j = k;
            }
            if (numbers[k] > numbers[j]) {
                i = k + 1;
            }
            k = (j - i) / 2 + i;
        }

        return numbers[k];
    }
}
