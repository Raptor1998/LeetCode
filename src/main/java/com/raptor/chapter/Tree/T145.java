package com.raptor.chapter.Tree;

import com.raptor.random.MixedAll;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author raptor
 * @description T145
 * @date 2022/2/23 19:44
 */
public class T145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        recur(root, list);
        return list;
    }

    public static void pre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        pre(root.left, list);
        pre(root.right, list);
    }

    public static void recur(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recur(root.left, list);
        recur(root.right, list);
        list.add(root.val);
    }


    //层序
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            ArrayList<Integer> objects = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode poll = queue.poll();
                objects.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            list.add(objects);
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode4.right = treeNode6;

        //List<Integer> list = postorderTraversal(treeNode1);
        //for (int i = 0; i < list.size(); i++) {
        //    System.out.println(list.get(i));
        //}
        List<List<Integer>> list = levelOrder(treeNode1);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
