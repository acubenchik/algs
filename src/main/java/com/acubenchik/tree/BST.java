package com.acubenchik.tree;

public class BST {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(5);
        bst.add(3);
        bst.add(6);
        bst.add(2);
        bst.add(4);
//        bst.preorder(bst.root);
        bst.inorder(bst.root);
//        bst.postOrder(bst.root);
        bst.delete(5);

    }
    Node root;

    public void add(int key){
        this.root = insert(this.root, key);
    }

    private int maxKeyInLeftSubtree(Node node) {
        while(node.right!=null) {
            return maxKeyInLeftSubtree(node.right);
        }
        return node.key;
    }

    public void delete(int key) {
        deleteKey(key, this.root);
    }

    private Node deleteKey(int key, Node currentNode) {
        if(key == currentNode.key) {
            if(currentNode.right!= null && currentNode.left!=null) {
                int newKey = maxKeyInLeftSubtree(currentNode.left);
                currentNode.key = newKey;
                currentNode.left = deleteKey(newKey, currentNode.left);


            } else if(currentNode.right== null && currentNode.left==null) {
                return null;
            } else if (currentNode.right != null  && currentNode.left==null) {
                return  currentNode.right;
            } else if (currentNode.right == null  && currentNode.left!=null) {
                return currentNode.left;
            }
        } else if (key < currentNode.key) {
            currentNode.left =  deleteKey(key, currentNode.left);
        } else {
            currentNode.right = deleteKey(key, currentNode.right);
        }
        return currentNode;
    }

    public void preorder(Node root){
        if(root == null) {
            return;
        }
        System.out.println(root.key);
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }


    public void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.key);
    }

    public Node insert(Node root, int key) {
        if(root == null) {
            root = new Node(null, null, key);
        } else if(key < root.key) {
            root.left = insert(root.left, key);
        } else if(key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }




}

class Node {
    public Node left;
    public Node right;
    public int key;
    public int value;

    public Node(Node left, Node right, int key) {
        this.left = left;
        this.right = right;
        this.key = key;
    }
}