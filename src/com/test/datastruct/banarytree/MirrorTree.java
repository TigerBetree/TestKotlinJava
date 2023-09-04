package com.test.datastruct.banarytree;

import java.util.Stack;

public class MirrorTree {

    /**
     * 根据后续遍历的特点 左 -> 右 -> 根，交换左右节点的顺序即可
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;

        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    /**
     * 利用 后续遍历 非递归的方式，交换左右节点顺序
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
