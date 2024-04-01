package com.test.java.datastruct.banarytree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDepth {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++; // 每遍历一层，深度加1

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // 将当前节点的子节点加入队列
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return depth;
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树:
        //     3
        //    / \
        //   9  20
        //     /  \
        //    15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("二叉树的深度为: " + maxDepth(root)); // 输出应为3
    }
}
