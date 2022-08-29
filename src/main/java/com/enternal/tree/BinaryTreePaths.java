package com.enternal.tree;

import com.raptor.chapter.Tree.AllPaths;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/23  17:32
 */
public class BinaryTreePaths {


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> p = new ArrayList<>();
        allPaths(list, root, p);
        return list;
    }

    public static void allPaths(List<String> list, TreeNode root, List<Integer> path) {
        if (root != null) {
            path.add(root.val);
        }
        if (root.left == null && root.right == null) {
            String s = new String();
            for (Integer integer : path) {
                s += (integer + "->");
            }
            s = s.substring(0, s.length() - 2);
            list.add(s);
        }
        if (root.left != null) {
            allPaths(list, root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            allPaths(list, root.right, path);
            path.remove(path.size() - 1);
        }
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

        List<String> list1 = binaryTreePaths(treeNode1);
        list1.forEach(item -> {
            System.out.println(item);
        });

    }
}
