package com.raptor.chapter.Tree;

public class T110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depth1 = depth(root.left);
        int depth2 = depth(root.right);
        if (Math.abs(depth1 - depth2) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        System.out.println(new T110().isBalanced(treeNode1));
    }
}
