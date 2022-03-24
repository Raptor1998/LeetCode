package com.raptor.chapter.Tree;

import java.util.ArrayList;
import java.util.List;

public class T257 {
    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<>();
        allPaths(root, path);
        return paths;
    }

    public void allPaths(TreeNode root, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
        }
        //叶子节点
        if (root != null && root.left == null && root.right == null) {
//            StringBuffer stringBuffer = new StringBuffer();
//            for (int i = 0; i < path.size(); i++) {
//                stringBuffer.append(path + "->");
//            }
//            paths.add(stringBuffer.toString());
            for (Integer integer : path) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        if (root.left != null) {
            allPaths(root.left, path);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            allPaths(root.right, path);
            path.remove(path.size()-1);
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
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode4.right = treeNode6;

        T257 t257 = new T257();
        t257.binaryTreePaths(treeNode1);

    }
}
