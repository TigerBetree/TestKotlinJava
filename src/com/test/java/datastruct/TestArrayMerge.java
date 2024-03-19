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

        System.out.println();
        System.out.println();

        int[] a2 = {1, 3, 5, 7, 9}; // 这是数组a
        int[] b2 = {2, 4, 6, 8, 10, 11, 12}; // 这是数组b
        // 调用方法进行插入操作
        int[] result2 = insertElements(a2, b2);
        // 打印结果
        for (int i : result2) {
            System.out.print(i + " ");
        }
    }

    /**
     * 将数组b的元素插入到数组a中，每隔两个元素插入一个b的元素
     *
     * @param a 数组a
     * @param b 数组b
     * @return 返回新的合并后的数组
     */
    public static int[] insertElements(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int totalLen = aLen + bLen; // 计算新数组的总长度
        int[] result = new int[totalLen];
        int aIndex = 0, bIndex = 0, resultIndex = 0;
        // 遍历数组a和b，按照规则插入元素
        while (aIndex < aLen && bIndex < bLen) {
            // 先插入a的元素
            result[resultIndex++] = a[aIndex++];
            // 如果a的当前元素不是最后一个，再插入一个a的元素
            if (aIndex < aLen) {
                result[resultIndex++] = a[aIndex++];
            }
            // 插入b的元素
            result[resultIndex++] = b[bIndex++];
        }
        // 处理数组a或b剩余的元素
        while (aIndex < aLen) {
            result[resultIndex++] = a[aIndex++];
        }
        while (bIndex < bLen) {
            result[resultIndex++] = b[bIndex++];
        }
        return result;
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
