package com.acubenchik.tree;

public class BinaryTreeFromPreAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(inorder, 0, inorder.length -1, preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] inOrder, int inStart, int inEnd, int [] preOrder, int preStart, int preEnd) {
        if(inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int rootValue = preOrder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int k = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if(rootValue==inOrder[i]) {
                k=i;
                break;
            }
        }
        root.left = build(inOrder, inStart, k-1, preOrder, preStart +1, preStart +k - (inStart));
        root.right = build(inOrder, k+1, inEnd, preOrder, preStart +k - inStart +1, preEnd);
        return root;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
