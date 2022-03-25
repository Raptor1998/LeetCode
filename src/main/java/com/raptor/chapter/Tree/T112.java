package com.raptor.chapter.Tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        ArrayList<Integer> objects = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        allPath(root, objects, sum);
        for (int i = 0; i < sum.size(); i++) {
            if (sum.get(i) == targetSum){
                return true;
            }
        }
        return false;
    }

    public void allPath(TreeNode root, List<Integer> path, List<Integer> sum) {
        if(root!=null){
            path.add(root.val);
        }

        //叶子节点
        if (root != null && root.left == null && root.right == null) {
            int t = 0;
            for (Integer integer : path) {
                t += integer;
            }
            sum.add(t);
        }

        if (root.left != null) {
            allPath(root.left, path, sum);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            allPath(root.right, path, sum);
            path.remove(path.size() - 1);
        }

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
        //treeNode2.left = treeNode4;
//        treeNode3.left = treeNode5;
        //treeNode4.right = treeNode6;
        int t = 5;
        System.out.println(new T112().hasPathSum(treeNode1, t));
    }
}
