package com.test.java.datastruct.link;

import java.util.HashSet;
import java.util.Set;

public class LinkDemo {

    /**
     * 单链表反转1
     * <p>
     * TODO 比较难理解
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        Node next = head.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = prev;
        return cur;
    }

    /**
     * 单链表反转2
     * <p>
     * TODO 容易理解
     *
     * @param head
     * @return
     */
    public static Node reverseList(Node head) {
        //如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node next = null; //定义当前结点的下一个结点
        Node reverseHead = null;  //反转后新链表的表头

        while (current != null) {
            next = current.next;  //暂时保存住当前结点的下一个结点，因为下一次要用

            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
            reverseHead = current;

            current = next;   // 操作结束后，current节点后移
        }

        return reverseHead;
    }

    /**
     * 是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 判断链表中是否有环
    public static boolean existsCircle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 判断链表中是否有环[利用HashSet]
    public boolean hasCycle2(Node head) {
        Set<Node> seen = new HashSet<Node>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 两个有序的链表合并
    public static Node merge(Node head1, Node head2) {
        Node guard = new Node('/');
        Node cur = guard;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                while (head1 != null && head1.val <= head2.val) {
                    cur.next = head1;
                    cur = cur.next;
                    head1 = head1.next;
                }
            } else {
                while (head2 != null && head1.val > head2.val) {
                    cur.next = head2;
                    cur = cur.next;
                    head2 = head2.next;
                }
            }
        }

        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }

        return guard.next;
    }

    /**
     * 从有序链表中删除重复节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * 交换链表中的相邻结点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next, l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }
        return node.next;
    }

    // 删除链表倒数第 n 个结点
    public static Node deleteLastN(Node head, int n) {
        if (n < 1 || head == null) {
            return head;
        }
        Node guard = new Node('/');
        guard.next = head;

        Node slow = guard;
        Node fast = guard;

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

    // 求链表的中间结点
    public static Node getMiddle(Node head, int n) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1, l2, 0);
    }

    public static ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry == 0 ? null : new ListNode(carry);
        }
        if (l1 == null && l2 != null) {
            l1 = new ListNode(0);
        }
        if (l2 == null && l1 != null) {
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + carry;
        ListNode curr = new ListNode(sum % 10);
        curr.next = helper(l1.next, l2.next, sum / 10);
        return curr;
    }

    // 大数相加
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        if (l1 == null && l2 == null) {
            return dummyHead;
        }
        int sum = 0, carry = 0;
        ListNode curr = dummyHead;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
