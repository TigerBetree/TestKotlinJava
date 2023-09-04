package com.test.java.datastruct;

import java.util.Arrays;

public class TwoSumInSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        int m = 11;
        int[] result = findTwoSum(arr1, arr2, m);
        if (result != null) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("No solution found.");
        }
    }

    public static int[] findTwoSum(int[] arr1, int[] arr2, int m) {
        int i = 0, j = arr2.length - 1;
        while (i < arr1.length && j >= 0) {
            int sum = arr1[i] + arr2[j];
            if (sum == m) {
                return new int[]{arr1[i], arr2[j]};
            } else if (sum < m) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void findSum(int[] arr1, int[] arr2, int m) {
        int i = 0, j = arr2.length - 1;
        while (i < arr1.length && j >= 0) {
            int sum = arr1[i] + arr2[j];
            if (sum == m) {
                System.out.println("找到了两个数：" + arr1[i] + "和" + arr2[j]);
            }
            i++;
            j--;
        }
        System.out.println("No solution found.");
    }
}
