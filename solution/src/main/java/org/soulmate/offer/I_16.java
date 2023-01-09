package org.soulmate.offer;

public class I_16 {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n > 0) {
            double pow = myPow(x, n / 2);
            if (n % 2 == 0)
                return pow * pow;
            else
                return x * pow * pow;
        } else {
            return 1.0 / (x * myPow(x, -(n + 1)));
        }
    }


}
