package com.test.java.datastruct;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 进行求topK的问题
 */
public class TopK {

    /**
     * 求数据中前K大数据
     *
     * @param data
     * @param k
     * @return
     */
    public static int[] topk(int[] data, int k) {
        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < data.length; i++) {
            if (queue.size() < k) {
                queue.offer(data[i]);
            } else {
                int value = queue.peek();
                // 如果发现数据比堆顶元素大，则加入到小顶堆中
                if (data[i] > value) {
                    queue.poll();
                    queue.offer(data[i]);
                }
            }
        }

        int[] result = new int[k];
        int index = 0;
        // 遍历完成后，小顶堆的数据就为需要求得的topk的数据
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] d = new int[]{6, 2, 5, 2, 7, 10, 2, 3};
        int[] r = topk(d, 3);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }

        System.out.println("==================");
        System.out.println(getSmallKthData(d, 5));
    }

    public static int getSmallKthData(int[] data, int k){
        PriorityQueue<Integer> queue = new PriorityQueue(k, Comparator.reverseOrder());
        for(int i = 0; i < data.length; i++){
            if(queue.size() < k){
                queue.offer(data[i]);
            } else {
                int temp = queue.peek();
                if(temp > data[i]){
                    queue.poll();
                    queue.offer(data[i]);
                }
            }
        }

        return queue.peek();
    }
}

