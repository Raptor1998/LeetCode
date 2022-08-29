package com.enternal.tree;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/23  20:50
 */
public class IsBalance {
    public static boolean isBalanced(TreeNode root) {
        if (root == null ){
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1 ){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    public static int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))  + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);

        TreeNode treeNode6 = new TreeNode(55);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        treeNode4.left = treeNode6;
        System.out.println(isBalanced(treeNode1));

    }
}
