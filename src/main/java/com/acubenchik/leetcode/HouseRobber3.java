package com.acubenchik.leetcode;

public class HouseRobber3 {

    public int rob(TreeNode root) {
        int [] res = visit(root);
        return Math.max(res[0], res[1]);
    }

    private int[] visit(TreeNode node){
        if(node == null) {
            return new int[]{0,0};
        }
        int [] profit = new int[2];
        int [] left = visit(node.left);
        int [] right = visit(node.right);
        profit[1] = node.val + left[0] + right[0];
        profit[0] = Math.max(Math.max(Math.max(left[1] + right[1], left[0] + right[1]),  left[1] + right[0]), left[0] + right[0]);
        return profit;
    }
}
