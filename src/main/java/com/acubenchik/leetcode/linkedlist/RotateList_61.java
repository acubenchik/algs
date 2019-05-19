package com.acubenchik.leetcode.linkedlist;

public class RotateList_61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
//        ListNode head2 = new ListNode(3);
//        ListNode head3 = new ListNode(4);
//        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = null;
//        head2.next = head3;
//        head3.next = head4;
//        head4.next = null;

        new RotateList_61().rotateRight(head, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        int size = 1;
        ListNode temp = head;
        while(temp.next!= null) {
            size++;
            temp = temp.next;
        }
        ListNode tail = temp;

        int moves = k%size;
        if (moves == 0) {
            return head;
        }

        ListNode current = head;
        for(int i = 0; i < size - moves -1; i++) {
            current = current.next;
        }
        ListNode nextHead = current.next;
        current.next = null;
        tail.next = head;

        return nextHead;
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
