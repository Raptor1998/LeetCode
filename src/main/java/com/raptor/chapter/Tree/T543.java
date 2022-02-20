package com.raptor.chapter.Tree;

/**
 * @author raptor
 * @description T543
 * @date 2022/2/18 9:32
 */
public class T543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        System.out.println(left);
        System.out.println(right);
        return left + right;
    }

    public int depthSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depthSum(root.left);
        int right = depthSum(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        //treeNode2.left = treeNode3;
        //treeNode1.right = treeNode4;
        //treeNode4.left = treeNode5;
        System.out.println(new T543().diameterOfBinaryTree(treeNode1));
    }
}
