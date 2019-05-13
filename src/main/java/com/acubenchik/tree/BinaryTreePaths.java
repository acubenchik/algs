package com.acubenchik.tree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        recursive(root, "", result);
        return  result;
    }

    private void recursive(TreeNode root, String path, List<String> result) {
        path += path.isEmpty() ? root.val : "->" + root.val;
        if(root.right == null && root.left == null) {
            result.add(path);
            return;
        }
        if(root.left != null ) recursive(root.left, path, result);
        if(root.right != null )recursive(root.right, path, result);
    }

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
