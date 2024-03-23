package com.test.java.datastruct.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环问题
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * Josephus环的四种解法(约瑟夫环)
 * 巧解约瑟夫环问题
 */
public class JosephusCircle {

    public static int josephusCircle(int n, int m) {
        // 这里用一个集合模拟队列
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        // 计数器，记录报数序号
        int count = 0;
        // 当前循环的队列位置索引
        int index = 0;

        while (list.size() > 1) {
            count++;

            // 这里还要注意一个问题，如果报数来到了队列尾部，我们需要从第一个人继续往下报数
            // 因此这里的索引计数器需要归0
            if (index >= list.size()) {
                index = 0;
            }

            // 接下来开始循环报数，将序号为m的人移出队列
            if (count >= m) {
                // 移出队列，同时计数器归0
                list.remove(index);
                count = 0;
                // 这里的索引要减1
                index--;
            }

            index++;
        }

        return list.get(0);
    }
}
