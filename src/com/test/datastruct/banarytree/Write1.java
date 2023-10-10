package com.test.datastruct.banarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Write1 {

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    /**
     * TODO test
     *
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<Integer> list = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.addFirst(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }

            if (root.right != null) {
                stack.push(root.right);
            }
        }

        int i = 0;
        while (!list.isEmpty()) {
            System.out.print(list.indexOf(i++) + " ");
        }
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.peek();
            System.out.println(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

    /**
     * 纯练手感
     *
     * @param root
     */
    public static void levelOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.peek();
            System.out.println(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }


    public static void findSum(int[] arr1, int[] arr2, int m) {
        int i = 0, j = arr2.length - 1;
        while (i < arr1.length && j >= 0) {
            int sum = arr1[i] + arr2[j];
            if (sum == m) {
                System.out.println("找到了两个数：" + arr1[i] + "和" + arr2[j]);
            }
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] m = new int[]{1, 3, 5, 7, 9};
        int[] n = new int[]{2, 4, 6, 8, 10};
        int target = 11;
        findSum(m, n, target);
    }
}
