package com.test.java.datastruct.banarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demo2 {

    /**
     * 合并二叉树
     * <a href="https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/">...</a>
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    /**
     * 判断路径和是否等于一个数
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 子树
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 是否是相等的树
     *
     * @param s
     * @param t
     * @return
     */
    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (t.val != s.val) return false;
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }

    /**
     * 二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的深度
        int left = minDepth(root.left);
        // 计算右子树的深度
        int right = minDepth(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * 统计左叶子节点的和
     *
     * @param root
     * @return
     */
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) return 0;
//        if (isLeaf(root.left)) {
//            return root.left.val + sumOfLeftLeaves(root.right);
//        }
//        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
//    }
//
//    private boolean isLeaf(TreeNode node) {
//        if (node == null) return false;
//        return node.left == null && nt == null;
//    }


    /**
     * 一棵树每层节点的平均数【基于层序遍历】
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ret.add(sum / cnt);
        }
        return ret;
    }

    /**
     * 得到左下角的节点
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
