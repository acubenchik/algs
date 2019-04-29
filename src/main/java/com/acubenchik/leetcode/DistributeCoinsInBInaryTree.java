package com.acubenchik.leetcode;
//https://leetcode.com/problems/distribute-coins-in-binary-tree/
public class DistributeCoinsInBInaryTree {
    private int answer = 0;


    public int distributeCoins(TreeNode root) {
        answer = 0;
        preOrder(root);
        return answer;
    }

    public int preOrder(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = preOrder(root.left);
        int right = preOrder(root.right);
        int coinsNeeded = left + right + root.val - 1;
        answer += Math.abs(coinsNeeded);
        return coinsNeeded;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
