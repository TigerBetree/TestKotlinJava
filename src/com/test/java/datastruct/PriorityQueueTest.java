package com.test.java.datastruct;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue1.add(2);
        queue1.add(1);
        queue1.add(3);

        while (!queue1.isEmpty()) {
            Integer i = queue1.poll();
            System.out.println(i);
        }

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.id - o2.id);
            }
        };

        Queue<Student> queue2 = new PriorityQueue<Student>(comparator);
        queue2.add(new Student(2, "B"));
        queue2.add(new Student(1, "A"));
        queue2.add(new Student(3, "C"));

        while (!queue2.isEmpty()) {
            Student s = queue2.poll();
            System.out.println(s.toString());
        }

        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        System.out.println(Arrays.toString(smallestK(arr, 4)));
    }

    public static int[] smallestK(int[] arr, int k) {
        if(k < 1){
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.add(arr[i]);
            } else {
                int cur = arr[i];
                int temp = queue.peek();
                if (temp > cur) {
                    queue.poll();
                    queue.add(cur);
                }
            }
        }

        int[] r = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            r[i++] = queue.poll();
        }
        return r;
    }

    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return id + "-" + name;
        }
    }

}
