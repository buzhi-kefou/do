package org.soulmate.ordinary;

public class P1352 {
    static class ProductOfNumbers {
        int[] prefix;
        int mul = 1, ptr = 0, zero = -1;

        public ProductOfNumbers() {
            prefix = new int[40000];
        }

        public void add(int num) {
            if (num == 0) {
                zero = ptr;
                mul = 1;
                num = 1;
            }
            mul *= num;
            prefix[ptr++] = mul;
        }

        public int getProduct(int k) {
            int prev = ptr - k - 1;
            if (zero > prev) return 0;
            if (prev < 0) return prefix[ptr - 1];
            return prefix[ptr - 1] / prefix[prev];
        }
    }
}
