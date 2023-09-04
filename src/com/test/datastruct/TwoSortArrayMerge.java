package com.test.datastruct;

import java.util.Arrays;

/**
 * 实现两个有序数组合并为一个有序数组
 */
public class TwoSortArrayMerge {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 10};
        int[] b = new int[]{2, 4, 5, 8, 12};
        int[] temp = merge(a, b);
        System.out.println(Arrays.toString(temp));

        System.out.println(Arrays.toString(merge(a, new int[]{})));
        System.out.println(Arrays.toString(merge(a, null)));
        System.out.println(Arrays.toString(merge(null, b)));
        System.out.println(Arrays.toString(merge(null, null)));
        System.out.println();

//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            int target = nums2[i];
            int index = m + i - 1;
            while (index >= 0 && nums1[index] > target) {
                nums1[index + 1] = nums1[index];
                index--;
            }
            nums1[index + 1] = target;
        }
    }

    public static int[] merge(int[] a, int[] b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        int len = a.length + b.length;
        int[] m = new int[len];

        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < len; i++) {
            if (aIndex < a.length && bIndex < b.length) {
                if (a[aIndex] >= b[bIndex]) {
                    m[i] = b[bIndex++];
                } else {
                    m[i] = a[aIndex++];
                }
            } else {
                if (aIndex < a.length) {
                    m[i] = a[aIndex++];
                } else {
                    m[i] = b[bIndex++];
                }
            }
        }

        return m;
    }
}
