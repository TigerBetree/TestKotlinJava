package com.test.java.datastruct.link;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断两个链表是否相交
 */
public class TestIntersect {

    /**
     * 哈希法
     *
     * @param headA
     * @param headB
     * @return
     */
    public boolean isIntersect(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (visited.contains(headB)) {
                return true;
            }
            headB = headB.next;
        }
        return false;
    }

    /**
     * 双指针
     *
     * @param headA
     * @param headB
     * @return
     */
    public boolean isIntersect2(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // 让headA为较长的链表
        if (lenA < lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int diff = Math.abs(lenA - lenB);
        // 让较长链表先前进diff个节点
        while (diff-- > 0) {
            headA = headA.next;
        }
        // 两个链表同时前进，如果相遇则相交
        while (headA != null && headB != null) {
            if (headA == headB) {
                return true;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return false;
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 返回相交的节点
     *
     * 解决这个问题的关键是，通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1。
     *
     * 所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，
     * 让 p2 遍历完链表 B 之后开始遍历链表 A，
     * 这样相当于「逻辑上」两条链表接在了一起
     *
     * <a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/#%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E7%9B%B8%E4%BA%A4">...</a>
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}
