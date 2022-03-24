package com.raptor.chapter.Tree;

public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        //如果为空或者只有一个节点
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 != null && treeNode2 != null && treeNode1.val == treeNode2.val) {
            return judge(treeNode1.left, treeNode2.right) && judge(treeNode1.right, treeNode2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(new Offer28().isSymmetric(treeNode1));
    }
}
