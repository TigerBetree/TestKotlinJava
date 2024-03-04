package com.test.java.datastruct;

/**
 * 题目：
 * 有两个数组: int[] a; int[] b;
 * 需要把 b 中的元素，插入到 a 中；
 * 插入规则：a数组中，每隔2个元素，插入一个b数组的元素；a或b多余的元素补在后面；
 * 实例：
 * a = {1,2,3,4,5,6,7}
 * b = {11,22,33,44,55}
 * 结果:
 * c = {1,2,11,3,4,22,5,6,33,7,44,55}
 */
public class TestArrayMerge {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {11, 22, 33, 44, 55};
        int[] result = mergeArray(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }

    private static int[] mergeArray(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            return b;
        }
        if (b == null || b.length == 0) {
            return a;
        }

        int[] result = new int[a.length + b.length];

        int aIndex = 0;
        int bIndex = 0;

        int counter = 0;
        for (int i = 0; i < result.length; i++) {
            if (counter == 2) {
                if (aIndex < a.length && bIndex < b.length) {
                    result[i] = b[bIndex++];
                    counter = 0;
                } else if (aIndex < a.length) {
                    result[i] = a[aIndex++];
                } else if (bIndex < b.length) {
                    result[i] = b[bIndex++];
                }
            } else {
                if (aIndex < a.length) {
                    result[i] = a[aIndex++];
                    counter++;
                } else {
                    if (bIndex < b.length) {
                        result[i] = b[bIndex++];
                    }
                }
            }
        }
        return result;
    }
}
