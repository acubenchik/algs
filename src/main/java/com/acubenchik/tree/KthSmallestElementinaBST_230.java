package com.acubenchik.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementinaBST_230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        visit(root, res, k);
        return res.get(res.size()-1);
    }

    private void visit(TreeNode root, List<Integer> values, int k) {
        if(root == null) {
            return;
        }
        visit(root.left, values, k);
        if(values.size() ==k) {
            return;
        }
        values.add(root.val);
        visit(root.right, values, k);
    }

     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}
