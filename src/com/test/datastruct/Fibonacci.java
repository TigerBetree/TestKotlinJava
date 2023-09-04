package com.test.datastruct;

/**
 * 费布那切 + 求阶乘
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(Fibonacci(5));
        System.out.println();

        System.out.println(fibonacci(15));
        System.out.println(Fibonacci(15));
        System.out.println();

        System.out.println(factorial(5));
        System.out.println(factorial(6));
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 2 || n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int Fibonacci(int n) {
        int FibonacciFirst = 0;
        int FibonacciSecond = 1;
        int FibonacciN = 0;
        if (n == 0) {
            return FibonacciFirst;
        }
        if (n == 1) {
            return FibonacciSecond;
        }
        for (int i = 2; i <= n; i++) {
            // 递推地求 F(n)
            FibonacciN = FibonacciFirst + FibonacciSecond;
            // 下面更新保存数组的中间值
            FibonacciFirst = FibonacciSecond;
            FibonacciSecond = FibonacciN;
        }
        return FibonacciN;
    }

    /**
     * 求阶乘
     * @param number
     * @return
     */
    public static long factorial(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
