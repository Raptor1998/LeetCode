package com.raptor.chapter.bytedance;

import com.raptor.chapter.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int right = -1;
            int null_num = 0;
            int left = -1;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    System.out.print(poll.val + " ");
                } else {
                    System.out.print("null ");
                }

                if (poll == null) {
                    null_num++;
                    queue.add(null);
                    queue.add(null);
                    continue;
                }
                if (poll != null) {
                    right = i;
                }
                if (poll != null && left == -1) {
                    left = i;
                }
                queue.add(poll.left);
                queue.add(poll.right);
            }
            if (right != -1) {
                maxWidth = Math.max(maxWidth, right - left + 1);
            }
            System.out.println();
            if (null_num == size) {
                return maxWidth;
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;

        treeNode4.left = treeNode6;
        treeNode5.left = treeNode7;

        System.out.println(new WidthOfBinaryTree().widthOfBinaryTree(treeNode1));
    }
}
