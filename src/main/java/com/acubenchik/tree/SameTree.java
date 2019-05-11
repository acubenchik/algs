package com.acubenchik.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/same-tree/
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        order(first, p);
        order(second, q);
        return first.equals(second);

    }

    void order(List<Integer> order, TreeNode node) {
        if(node == null) {
            order.add(null);
            return;
        } else {
            order.add(node.val);
            order(order, node.left);
            order(order, node.right);

        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}



