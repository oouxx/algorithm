package com.wxx.leetcode.code_198;

class Solution{
    public int rob(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int pre1 = 0;
        int pre2 = 0;
        for (int i = 0; i < nums.length; i++){
            int cur = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}