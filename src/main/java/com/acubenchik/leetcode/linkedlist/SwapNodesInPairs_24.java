package com.acubenchik.leetcode.linkedlist;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs_24 {

        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) {
                return head;
            }
            ListNode first = head;
            ListNode second = head.next;

            first.next = swapPairs(second.next);
            second.next = first;
            return second;
        }


}
