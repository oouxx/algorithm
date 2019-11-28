package com.wxx.leetcode.code_70;
class Solution{
    public int climbStairs(int n){
        if (n <= 2){
            return n;
        }
        int pre1 = 1, pre2 = 2;
        for(int i = 2; i < n; i++){
            int cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}