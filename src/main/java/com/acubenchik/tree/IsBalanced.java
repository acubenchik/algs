package com.acubenchik.tree;

public class IsBalanced {

    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        visit(root);
        return isBalanced;
    }

    private int visit(TreeNode root){
        if(root == null || !isBalanced) {
            return 0;
        }
        int left = visit(root.left);
        int right = visit(root.right);
        if(Math.abs(left-right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }

    class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
}
