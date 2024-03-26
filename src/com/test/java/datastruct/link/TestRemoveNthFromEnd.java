package com.test.java.datastruct.link;

/**
 * 删除链表的倒数第N个结点
 */
public class TestRemoveNthFromEnd {


    // 主函数
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
    }

    /**
     * 删除链表倒数第n个结点
     */
    public static ListNode deleteLastNthNode(ListNode head, int n) {
        if (n < 1 || head == null) {
            return head;
        }

        ListNode guard = new ListNode();
        guard.next = head;

        ListNode fast = guard;
        ListNode slow = guard;

        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return guard.next;
    }
}
