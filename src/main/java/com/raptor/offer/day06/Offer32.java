package com.raptor.offer.day06;

import com.sun.istack.internal.NotNull;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author raptor
 * @description Offer32
 * @date 2021/12/20 17:10
 */
public class Offer32 {

    public static int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ans[i++] = integer;
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        int[] ints = levelOrder(null);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
