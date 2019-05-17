package com.acubenchik.leetcode.linkedlist;

public class ReverseList_206 {

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
