package com.acubenchik.gs;

public class QuickSort {

    public static void main(String[] args) {
        int [] arr = new int [] {1,2,3,4,5};
        new QuickSort().quickSort(arr, 0, arr.length -1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


        Node root = new Node();
        Node four = new Node();
        Node three = new Node();
        Node two = new Node();
        two.val = 2;
        three.next = two;
        three.val = 3;
        four.val = 4;
        four.next = three;
        root.val = 5;
        root.next = four;
        new QuickSortSignleLinkedList().quickSort(root, null);
    }

    public void quickSort(int [] arr, int start, int end) {
        if(start < end) {
            int pivot = partitionHoare(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }

    }

    //hoare scheme
    public int partitionHoare(int[] arr, int start, int end) {
        int middle = arr[start + (end - start)/2];
        int i = start;
        while(true) {
            while (arr[i] < middle) {
                i++;
            }
            int j = end;
            while (arr[j] > middle) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    //lomuto scheme
    public int partition(int[] arr, int start, int end) {
        int i = start;
        for(int j = start; j < end; j++) {
            if(arr[j] < arr[end]) {
               swap(arr, i, j);
               i++;
            }


        }
        swap(arr, i, end);
        return i;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
class Node {
    int val;
    Node next;
}

class QuickSortSignleLinkedList {


    public void quickSort(Node start, Node end){
        Node[] result = partition(start, end);
        Node newHead = result[0];
        Node pivot = result[1];
        Node newEnd = result[2];
        if(newHead != pivot) {

        }
    }

    public Node[] partition(Node start, Node end){
        Node newHead = null;
        Node newTail = null;
        Node current = start;
        Node pivot = end;
        Node tail = end;
        Node previous = null;
        while(current != pivot) {
            if(current.val >= pivot.val) {
                Node temp = current.next;
                current.next = null;
                tail.next = current;
                tail = current;
                current = temp;

            } else {

                if(newHead == null) {
                    newHead = current;
                }
                current = current.next;
            }
        }
        if(newHead == null) {
            newHead = pivot;
        }
        newTail = tail;
        return new Node[]{newHead, pivot, newTail};

    }
    }

