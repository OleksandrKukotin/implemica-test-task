package com.github.oleksandrkukotin.implemica;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final CorrectParenthesesTask runner = new CorrectParenthesesTask();
    private static final FactorialDigitsSumTask factorialDigitsSumTask = new FactorialDigitsSumTask();

    public static void main(String[] args) {
        runner.run();
        logger.info("Sum of the factorial digits: " + factorialDigitsSumTask.run(100));
    }
}