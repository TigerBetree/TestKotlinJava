package com.test.datastruct.banarytree;

import java.util.*;

public class BanaryTree {

    /**
     * 二叉树的深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = maxDepth(root.left);
        int rightLevel = maxDepth(root.right);
        return Math.max(leftLevel, rightLevel) + 1;
    }

    /**
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    /**
     * 层序遍历
     *
     * @param root
     */
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    // ---------------------------------------------------------------------

    private int maxLevel = 0;
    private HashMap levelCountsMap = new HashMap<Integer, Integer>();

    /**
     * 是否是对称的
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        trace(root, 1);

        return (int) levelCountsMap.get(maxLevel) == (int) Math.pow(2, maxLevel - 1);
    }

    private void trace(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            maxLevel = Math.max(maxLevel, level);
        }

        if (levelCountsMap.containsKey(level)) {
            int counts = (int) levelCountsMap.get(level);
            levelCountsMap.put(level, counts + 1);
        } else {
            levelCountsMap.put(level, 1);
        }

        trace(root.left, level + 1);
        trace(root.right, level + 1);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
    // ---------------------------------------------------------------------

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> array = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pop();
            array.add(temp.val);
            cur = temp.right;
        }

        return array;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return arr;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            arr.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
        return arr;
    }

    // ---------------------------------------------------------------------

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        preOrder(root, 1, arr);
        Collections.reverse(arr);
        return arr;
    }

    private void preOrder(TreeNode root, int level, List<List<Integer>> arr) {
        if (root == null) {
            return;
        }

        if (arr.size() >= level) {
            ArrayList<Integer> d = (ArrayList<Integer>) arr.get(level - 1);
            d.add(root.val);
        } else {
            ArrayList<Integer> d = new ArrayList<>();
            d.add(root.val);
            arr.add(d);
        }

        preOrder(root.left, level + 1, arr);
        preOrder(root.right, level + 1, arr);
    }

    // ---------------------------------------------------------------------

    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> levelSize = new ArrayList<>();
        List<Double> levelSum = new ArrayList<>();
        preOrder(root, 0, levelSum, levelSize);

        List<Double> result = new ArrayList<>();
        for (int i = 0; i < levelSum.size(); i++) {
            result.add(levelSum.get(i) / levelSize.get(i));
        }
        return result;
    }

    private void preOrder(TreeNode root, int level, List<Double> levelSum, List<Integer> levelSize) {
        if (root == null) {
            return;
        }

        if (levelSum.size() == level) {
            levelSum.add(root.val + 0.0d);
            levelSize.add(1);
        } else {
            levelSum.set(level, levelSum.get(level) + root.val);
            levelSize.set(level, levelSize.get(level) + 1);
        }

        preOrder(root.left, level + 1, levelSum, levelSize);
        preOrder(root.right, level + 1, levelSum, levelSize);
    }

}
