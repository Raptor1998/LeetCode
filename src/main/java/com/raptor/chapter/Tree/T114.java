package com.raptor.chapter.Tree;

import com.raptor.base.day5.ListNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author raptor
 * @description T114
 * @date 2022/3/30 10:32
 */
public class T114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
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
        new T114().flatten(treeNode1);
        while (treeNode1 != null) {
            System.out.print(treeNode1.val + " ");
            treeNode1 = treeNode1.right;
        }
    }
}
