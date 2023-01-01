package org.soulmate.offer;

public class I_60 {

    public double[] dicesProbability(int n) {
        return func(n);
    }

    private double[] func(int n) {
        if (n == 1)
            return new double[]{1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6};

        double[] res = new double[5 * n + 1];
        double[] func = func(n - 1);
        double temp = 1.0 / 6;
        for (int j = 0; j < func.length; j++) {
            for (int i = 0; i < 6; i++) {
                res[i + j] += temp * func[j];
            }
        }
        return res;
    }
}
