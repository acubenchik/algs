package com.acubenchik.leetcode;



//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfThetree {

    public int maxDepth(TreeNode root) {
        return process(root);
    }

    public int process(TreeNode root){
        if(root == null) {
            return 0;
        }
        int right = process(root.right);
        int left = process(root.left);
        int currentHeight = Math.max(right, left);
        return currentHeight +1;

    }

    class TreeNode {
        TreeNode right;
        TreeNode left;
    }
}
