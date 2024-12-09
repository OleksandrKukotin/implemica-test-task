package com.github.oleksandrkukotin.implemica;

import java.util.Scanner;

public class TasksRunner {

    public void CorrectParenthesesTask() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        // Input validation loop
        while (n < 0) {
            System.out.print("Enter N (number of pairs of parentheses): ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("Please enter a non-negative integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                scanner.next(); // Clear invalid input
            }
        }

        long[] catalan = new long[n + 1];
        catalan[0] = 1;

        for (int i = 1; i <= n; i++) {
            catalan[i] = calculateCatalanForIndex(catalan, i);
        }

        System.out.println("Number of correct parenthesis expressions: " + catalan[n]);
    }

    private long calculateCatalanForIndex(long[] catalan, int index) {
        long sum = 0;
        for (int j = 0; j < index; j++) {
            sum += catalan[j] * catalan[index - j - 1];
        }
        return sum;
    }

}
