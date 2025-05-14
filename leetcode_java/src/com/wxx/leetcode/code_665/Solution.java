package com.wxx.leetcode.code_665;
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++){
            if(nums[i] >= nums[i - 1]){
                continue;
            }
            count++;
            // if 4,5,1 not 4,1,1 is 4,5,5 
            if(i - 2 >= 0 && nums[i - 2] > nums[i]){
                nums[i] = nums[i - 1];
            }else{
                nums[i - 1] = nums[i];
            }
        }
        return count - 1 <= 0;
    }
}