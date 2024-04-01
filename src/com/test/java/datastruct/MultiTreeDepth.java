package com.test.java.datastruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

/**
 * 计算多叉树的深度
 */
public class MultiTreeDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxChildDepth = 0;
        for (TreeNode child : root.children) {
            maxChildDepth = Math.max(maxChildDepth, maxDepth(child));
        }

        return maxChildDepth + 1;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode child : node.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        // 构建一个多叉树
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        TreeNode grandchild1 = new TreeNode(5);
        TreeNode grandchild2 = new TreeNode(6);
        TreeNode grandchild3 = new TreeNode(7);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        child1.children.add(grandchild1);
        child1.children.add(grandchild2);
        child2.children.add(grandchild3);

        // 计算深度
        MultiTreeDepth solution = new MultiTreeDepth();
        int depth = solution.maxDepth(root);
        System.out.println("多叉树的深度为 ：" + depth);
        System.out.println("多叉树的深度为2 ：" + maxDepth2(root));
    }
}
