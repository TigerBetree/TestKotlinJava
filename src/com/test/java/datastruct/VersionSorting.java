package com.test.java.datastruct;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 抖音面试题：
 * <p>
 * 数组versions是一个项目的版本号列表，因多人维护，不规则
 * 例如：versions=['1.45.0','1.5','6','3.3.3.3.3.3.3']
 * 排序后的数组：sorted=['1.5','1.45.0','3.3.3.3.3.3','6’]
 * 用Java写排序算法
 */
public class VersionSorting {
    public static void main(String[] args) {
        String[] versions = {"1.45.0", "1.5", "1.5.0", "1.5.1", "6", "3.3.3.3.3.3.3"};
//        String[] versions = {"1.45.0", "1.5", "6", "3.3.3.3.3.3.3"};

//        Arrays.sort(versions, new VersionComparator());
//        System.out.println(Arrays.toString(versions));

        System.out.println(Arrays.toString(sortVersions(versions)));
        System.out.println(Arrays.toString(sortVersions2(versions)));
    }

    public static String[] sortVersions(String[] versions) {
        Arrays.sort(versions, new Comparator<String>() {
            @Override
            public int compare(String v1, String v2) {
                String[] s1 = v1.split("\\.");
                String[] s2 = v2.split("\\.");
                int i = 0;
                while (i < s1.length && i < s2.length) {
                    int n1 = Integer.parseInt(s1[i]);
                    int n2 = Integer.parseInt(s2[i]);
                    if (n1 < n2) {
                        return -1;
                    } else if (n1 > n2) {
                        return 1;
                    }
                    i++;
                }
                while (i < s1.length) {
                    if (Integer.parseInt(s1[i]) > 0) {
                        return 1;
                    }
                    i++;
                }
                while (i < s2.length) {
                    if (Integer.parseInt(s2[i]) > 0) {
                        return -1;
                    }
                    i++;
                }
                return 0;
            }
        });
        return versions;
    }

    static class VersionComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String[] arr1 = s1.split("\\.");
            String[] arr2 = s2.split("\\.");
            int i = 0;
            while (i < arr1.length && i < arr2.length && arr1[i].equals(arr2[i])) {
                i++;
            }
            if (i < arr1.length && i < arr2.length) {
                int diff = Integer.parseInt(arr1[i]) - Integer.parseInt(arr2[i]);
                return Integer.compare(diff, 0);
            } else {
                return Integer.compare(arr1.length, arr2.length);
            }
        }
    }

    public static String[] sortVersions2(String[] versions) {
        Arrays.sort(versions, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] arr1 = s1.split("\\.");
                String[] arr2 = s2.split("\\.");
                int i = 0;
                while (i < arr1.length && i < arr2.length) {
                    int n1 = Integer.parseInt(arr1[i]);
                    int n2 = Integer.parseInt(arr2[i]);
                    if (n1 != n2) {
                        return n1 - n2;
                    }
                    i++;
                }
                return arr1.length - arr2.length;
            }
        });
        return versions;
    }

    public static String[] sortVersions3(String[] versions) {
        Arrays.sort(versions, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split("\\.");
                String[] arr2 = o2.split("\\.");
                int i = 0;
                while (i < arr1.length && i < arr2.length) {
                    int n1 = Integer.parseInt(arr1[i]);
                    int n2 = Integer.parseInt(arr2[i]);
                    if (n1 > n2) {
                        return 1;
                    } else if (n1 < n2) {
                        return -1;
                    }

                    i++;
                }

                return arr1.length - arr2.length;
            }
        });
        return versions;
    }


}