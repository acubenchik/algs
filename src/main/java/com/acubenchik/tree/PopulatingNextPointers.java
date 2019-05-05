package com.acubenchik.tree;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextPointers {

    public Node connect(Node root) {
        Node start = root;
        while(start != null) {
            Node temp = start;
            while (temp.next != null) {
                if(temp.left!=null && temp.right != null)
                    temp.left.next = temp.right;
                if (temp.next!= null && temp.right != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }
            if(temp.left != null && temp.right != null) {
                temp.left.next = temp.right;
            }
            start = start.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
