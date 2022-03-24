package com.raptor.chapter.Tree;


import java.util.LinkedList;
import java.util.Queue;

public class Offer55 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            ans++;
        }
        return ans;
    }

    public int minDepth(TreeNode root){
        if (root==null){
            return 0;
        }

        return Math.min(maxDepth(root.left) + 1, maxDepth(root.right) + 1);

    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
//        treeNode3.left = treeNode5;
        treeNode4.right = treeNode6;

        System.out.println(new Offer55().minDepth(treeNode1));

    }
}
