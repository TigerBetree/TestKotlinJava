package com.test.java.datastruct.link;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表：
 * https://github.com/hanggegreat/CS-Tree/blob/master/%E7%AE%97%E6%B3%95/leetcode-TOP100.md#23%E5%90%88%E5%B9%B6k%E4%B8%AA%E6%8E%92%E5%BA%8F%E9%93%BE%E8%A1%A8
 */
public class MergeKLists {

    /**
     * 利用最小堆
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        Queue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        while (!minHeap.isEmpty()) {
            pre.next = minHeap.poll();
            pre = pre.next;
            if (pre.next != null) {
                minHeap.offer(pre.next);
            }
        }
        return dummy.next;
    }

    /**
     * 顺序合并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = merge2Lists(ans, lists[i]);
        }
        return ans;
    }

    /**
     * 二分法
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return recursion(lists, 0, lists.length - 1);
    }

    private ListNode recursion(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = recursion(lists, left, mid);
        ListNode rightList = recursion(lists, mid + 1, right);
        return merge2Lists(leftList, rightList);
    }

    /**
     * 合并两个有序链表
     *
     * @param first
     * @param second
     * @return
     */
    public ListNode merge2Lists(ListNode first, ListNode second) {
        ListNode pre = new ListNode(-1);
        ListNode tail = pre;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        if (first != null) {
            tail.next = first;
        }
        if (second != null) {
            tail.next = second;
        }
        return pre.next;
    }
}
