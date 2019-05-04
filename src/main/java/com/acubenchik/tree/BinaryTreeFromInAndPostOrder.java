package com.acubenchik.tree;


//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class BinaryTreeFromInAndPostOrder {
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return build(inorder, 0, inorder.length - 1, postorder, 0 , postorder.length - 1);
        }

        private TreeNode build(int[] inOrder, int inStart, int inEnd, int [] postOrder, int postStart, int postEnd) {
            if(inStart > inEnd || postStart > postEnd) {
                return null;
            }
            int rootValue = postOrder[postEnd];
            TreeNode root = new TreeNode(rootValue);
            int k = 0;
            for (int i = 0; i < inOrder.length; i++) {
                if(rootValue==inOrder[i]) {
                    k=i;
                    break;
                }
            }
            root.left = build(inOrder, inStart, k-1, postOrder, postStart, postStart +k - (inStart+1));
            root.right = build(inOrder, k+1, inEnd, postOrder, postStart +k - inStart, postEnd - 1);
            return root;

        }
    }

     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
