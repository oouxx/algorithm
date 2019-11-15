package com.wxx.leetcode.code_141;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution { 
    public boolean hasCycle(ListNode head) { 
        if (head == null){ 
            return false;
        }
        ListNode fastPointer = head.next;
        ListNode slowPointer = head;
        while(slowPointer != null && fastPointer != null && fastPointer.next != null){
            if(fastPointer == slowPointer){
                return true;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return false;
    }
}