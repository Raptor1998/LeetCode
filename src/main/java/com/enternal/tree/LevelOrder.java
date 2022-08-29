package com.enternal.tree;

import java.util.*;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/23  17:25
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> treeNodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                treeNodes.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
            list.add(treeNodes);
        }
        return list;
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

        List<List<Integer>> lists = levelOrder(treeNode1);
        lists.forEach(item -> {
            item.forEach(node -> {
                System.out.print(node + " ");
            });
            System.out.println();
        });
    }
}
