package com.raptor.chapter.bytedance;

import com.raptor.chapter.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raptor
 * @description PathSum
 * @date 2022/4/12 10:25
 */
public class PathSum {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();
        allPath(root, list, targetSum);
        return ans;
    }

    public void allPath(TreeNode root, ArrayList<Integer> list, int target) {
        list.add(root.val);
        if (root.left == null && root.right == null) {
            //到达叶子节点
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum == target) {
                ans.add((List<Integer>) list.clone());
            }
        }
        if (root.left != null) {
            allPath(root.left, list, target);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            allPath(root.right, list, target);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);

        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;
        treeNode6.left = treeNode9;
        treeNode6.right = treeNode10;
        List<List<Integer>> list = new PathSum().pathSum(treeNode1, 22);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}


