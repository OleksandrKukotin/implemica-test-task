package com.github.oleksandrkukotin.implemica;

import java.math.BigInteger;

public class FactorialDigitsSumTask {

    public int run(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String factorialStr = factorial.toString();
        int sum = 0;
        for (char c : factorialStr.toCharArray()) {
            sum += Integer.parseInt(Character.toString(c));
        }

        return sum;
    }
}
