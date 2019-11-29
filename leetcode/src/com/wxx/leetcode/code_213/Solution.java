package com.wxx.leetcode.code_213;

class Solution{
    public int rob(int[] nums){
        int n = nums.length;
        if(nums == null || n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        return Math.max(rob(nums, 1, nums.length), rob(nums, 0, nums.length - 1));

    }
    public int rob(int[] nums, int start, int end){
        int pre1 = 0;
        int pre2 = 0;
        for (int i = start; i < end; i++){
            int cur = Math.max(pre1 + nums[i], pre2);
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }
}