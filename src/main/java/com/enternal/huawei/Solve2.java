package com.enternal.huawei;

import java.util.ArrayList;
import java.util.List;

public class Solve2 {
    public static void main(String[] args) {
        int [] root = new int[]{0,1,-1,3,2,2};
        int n = root.length;
        TreeNode[] treeNode1 = new TreeNode[n+1];
        treeNode1[1] = new TreeNode(root[1]);
        for (int i = 1; i < n; i++) {
            if (i * 2 >= n){
                break;
            }

            if ( i * 2 <= n){
                treeNode1[i*2] = new TreeNode(root[i*2]);
                treeNode1[i].left = treeNode1[i*2];
            }
            if ( (i*2) + 1 <= n){
                treeNode1[(i*2)+1] = new TreeNode(root[(i*2)+1]);
                treeNode1[i].right = treeNode1[(i*2)+1];
            }
        }
        double target = findTarget(treeNode1[1], 2);
        System.out.println(target);
    }

    public static double findTarget(TreeNode root,int target){
        if(root == null){
            return 0.0;
        }
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        findPaths(root,paths,allPaths);
        int num = 0;
        int all = allPaths.size();
        for (List<Integer> allPath : allPaths) {
            for (Integer val : allPath) {
                if (val == target){
                    num++;
                    break;
                }
            }
        }
        return (double) num / all;
    }

    public static void findPaths(TreeNode root,List<Integer> path,List<List<Integer>> allPaths){
        path.add(root.val);
        //到叶子节点
        if (root.left == null && root.right == null){
            List<Integer> ans = new ArrayList<>();
            for (Integer integer : path) {
                ans.add(integer);
                System.out.print(integer+" ");
            }
            System.out.println();
            allPaths.add(ans);
            return;
        }
        if (root.left!=null){
            findPaths(root.left,path,allPaths);
            path.remove(path.size()-1);
        }
        if (root.right !=null){
            findPaths(root.right,path,allPaths);
            path.remove(path.size()-1);
        }
    }
}

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
