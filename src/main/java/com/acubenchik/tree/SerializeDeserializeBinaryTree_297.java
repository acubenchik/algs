package com.acubenchik.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree_297 {

    public class Codec {

        private static final String SEPARATOR = ",";
        private static final String NULLNODE = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
          StringBuilder sb = new StringBuilder();
          buildString(root, sb);
          return sb.toString();
        }

        private void buildString(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULLNODE).append(SEPARATOR);
            } else {
                sb.append(root.val).append(SEPARATOR);
                buildString(root.left, sb);
                buildString(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.length() ==0) {
                return null;
            }
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(data.split(SEPARATOR)));
            return buildTree(queue);
        }

        private TreeNode buildTree(Queue<String> queue){
            String current = queue.remove();
            if(current.equals(NULLNODE)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(current));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
