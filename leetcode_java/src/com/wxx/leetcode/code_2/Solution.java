package com.wxx.leetcode.code_2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while (l2.next == null || l1.next == null) {
            ListNode currL1 = l1;
            ListNode currL2 = l2;
            // create dummy node, it just a placeholder
            // to hold a head of linkedlist
            ListNode dummyNode = new ListNode();
            ListNode curr = dummyNode;

            int carry = 0;

            while (currL1 != null || currL2 != null) {
                int sum = carry;
                if (currL1 != null) {
                    sum += currL1.val;
                    currL1 = currL1.next;
                }
                if (currL2 != null) {
                    sum += currL2.val;
                    currL2 = currL2.next;
                }
                int currentDigit = sum % 10;
                carry = sum / 10;
                curr.next = new ListNode(currentDigit);
                curr = curr.next;
            }
            if (carry == 1) {
                curr.next = new ListNode(1);
            }
            return dummyNode.next;

        }
        ListNode result = new ListNode(0);
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    };

    // 构造器
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}