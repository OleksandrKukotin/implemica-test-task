package com.github.oleksandrkukotin.implemica;

import java.util.Scanner;
import java.util.logging.Logger;

public class CorrectParenthesesTask {

    private static final Logger logger = Logger.getLogger(CorrectParenthesesTask.class.getName());

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        // Input validation loop
        while (n < 0) {
            logger.info("Enter N (number of pairs of parentheses): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n < 0) {
                    logger.warning("Please enter a non-negative integer.");
                }
            } else {
                logger.warning("Invalid input. Please enter a non-negative integer.");
                scanner.next(); // Clear invalid input
            }
        }

        long[] catalan = new long[n + 1];
        catalan[0] = 1;

        for (int i = 1; i <= n; i++) {
            catalan[i] = calculateCatalanForIndex(catalan, i);
        }
        String output = "Number of correct parenthesis expressions: " + catalan[n];
        logger.info(output);
        scanner.close();
    }

    private long calculateCatalanForIndex(long[] catalan, int index) {
        long sum = 0;
        for (int j = 0; j < index; j++) {
            sum += catalan[j] * catalan[index - j - 1];
        }
        return sum;
    }
}
