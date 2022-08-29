package com.enternal.tree;

import com.sun.xml.internal.fastinfoset.vocab.Vocabulary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/8/23  21:00
 */
public class GetMinimumDifference {

    public static int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> order = new ArrayList<>();
        midOrder(root,order);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < order.size()-1; i++) {
            min = Math.min(min,Math.abs(order.get(i)-order.get(i+1)));
        }
        return min;
    }

    public static void midOrder(TreeNode root, List<Integer> list){
        if (root == null ){
            return;
        }
        midOrder(root.left,list);
        list.add(root.val);
        midOrder(root.right,list);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(333);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        System.out.println(getMinimumDifference(treeNode1));
    }
}
