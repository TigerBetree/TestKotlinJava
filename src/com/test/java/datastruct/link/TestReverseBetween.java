package com.test.java.datastruct.link;

/**
 * 指定区域链表反转
 */
public class TestReverseBetween {
    public static void main(String[] args) {
        // 创建一个链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = reverseBetween(head, 2, 4);

        // 打印反转后的链表
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode pre = dump;
        ListNode start = head;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
            start = start.next;
        }

        ListNode reverseSubEnd = start;

        ListNode cur = start;
        ListNode reverseSubHead = null;
        ListNode next = null;
        for (int i = m; i <= n; i++) {
            next = cur.next;

            cur.next = reverseSubHead;
            reverseSubHead = cur;

            cur = next;
        }

        pre.next = reverseSubHead;
        reverseSubEnd.next = cur;

        return dump.next;
    }


    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        // 创建一个哑节点，它的next指向head，这样便于处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化指针
        ListNode pre = dummy;
        ListNode cur = head;

        // 将pre移动到需要反转部分的前一个节点
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        // 保存m位置的前一个节点和当前节点
        ListNode con = pre, tail = cur;

        // 反转从m到n的链表部分
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 将反转后的链表与原链表连接
        con.next = pre;
        tail.next = cur;

        return dummy.next;
    }


}
