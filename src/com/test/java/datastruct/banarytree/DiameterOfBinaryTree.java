package com.test.java.datastruct.banarytree;

/**
 * 二叉树的直径
 * <p>
 * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
 */
public class DiameterOfBinaryTree {
    int maxDiameter = 0; // 记录最大直径的长度

    // 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
    public int diameterOfBinaryTree(TreeNode root) {
        // 对每个节点计算直径，求最大直径
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }
}

//    public int diameterOfBinaryTree(TreeNode root) {
//        // 对每个节点计算直径，求最大直径
//        traverse(root);
//        return maxDiameter;
//    }
//
//    // 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
//    void traverse(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        // 对每个节点计算直径
//        int leftMax = maxDepth(root.left);
//        int rightMax = maxDepth(root.right);
//        int myDiameter = leftMax + rightMax;
//
//        // 更新全局最大直径
//        maxDiameter = Math.max(maxDiameter, myDiameter);
//
//        traverse(root.left);
//        traverse(root.right);
//    }
//
//    // 计算二叉树的最大深度
//    int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftMax = maxDepth(root.left);
//        int rightMax = maxDepth(root.right);
//        return 1 + Math.max(leftMax, rightMax);
//    }
//}

