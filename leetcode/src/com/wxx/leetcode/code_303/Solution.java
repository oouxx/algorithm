package com.wxx.leetcode.code_303;

class NumArray{
    private int[] sums;
    public NumArray(int[] nums){
        sums = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            sums[i] = i == 0 ? nums[0] : nums[i] + sums[i - 1];
        }
    }
    public int sumRange(int i, int j){
        return i == 0 ? sums[j] : sums[j] - sums[i - 1];
    }
}