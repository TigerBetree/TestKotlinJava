package com.test.java.datastruct.link;

public class Test3 {

    /**
     * 链表反转
     */
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        ListNode next = null;
        ListNode reverseHead = null;

        while(cur != null){
            next = cur.next;

            cur.next = reverseHead;
            reverseHead = cur;

            cur = next;
        }

        return reverseHead;
    }

    /**
     * 删除链表倒数第n个结点
     */
    public static ListNode deleteLastNthNode(ListNode head, int n){
        if(n < 1 || head == null){
            return head;
        }

        ListNode guard = new ListNode();
        guard.next = head;

        ListNode fast = guard;
        ListNode slow = guard;

        for(int i = 0; i < n; i++){
            if(fast != null){
                fast = fast.next;
            }
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return guard.next;
    }
}
