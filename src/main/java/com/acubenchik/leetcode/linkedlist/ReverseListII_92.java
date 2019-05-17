package com.acubenchik.leetcode.linkedlist;

public class ReverseListII_92 {

    //1 -> 2 -> 3 -> 4 -> 5
    //1 -> 2 <- 3 <- 4  5
    //fakeHead 1, fakeTail 2
    //fakeHead .next = 4; fakeTail.next = 5
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        ListNode fakeHead = null;
        ListNode fakeTail = null;
        ListNode current = head;
        ListNode previous = null;
        while(m > 1) {
            previous = current;
            current = current.next;
            m--;
            n--;
        }
        fakeHead = previous;
        fakeTail = current;
        ListNode next = null;
        while(n > 0)  {
            next  = current.next;
            current.next = previous;
            previous = current;
            current = next;
            n--;
        }
        if(fakeHead!=  null)
            fakeHead.next = previous;
        else
            head = previous;
        fakeTail.next = current;
        return head;

    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
