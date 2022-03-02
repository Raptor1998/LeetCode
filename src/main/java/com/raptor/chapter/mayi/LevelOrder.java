package com.raptor.chapter.mayi;

import com.raptor.chapter.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author raptor
 * @description CengciBianli
 * @date 2022/3/1 20:43
 */
public class LevelOrder {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            ArrayList<Integer> objects = new ArrayList<>();

            int currLength = queue.size();
            for (int i = 0; i < currLength; i++) {
                TreeNode poll = queue.poll();
                objects.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            level.add(objects);
        }
        int i = 0;
        int j = level.size()-1;
        while (i<j){
            List<Integer> list = level.get(i);
            level.set(i,level.get(j));
            level.set(j,list);
            i++;
            j--;
        }
        return level;
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

        List<List<Integer>> list = levelOrderBottom(treeNode1);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
