package com.enternal.tree;

import java.util.List;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/23  17:43
 */
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
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

        invertTree(treeNode1);
        List<List<Integer>> lists = LevelOrder.levelOrder(treeNode1);
        lists.forEach(item -> {
            item.forEach(node -> {
                System.out.print(node + " ");
            });
            System.out.println();
        });
    }
}
