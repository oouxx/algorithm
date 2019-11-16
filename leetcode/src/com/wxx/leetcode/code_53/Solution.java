package com.wxx.leetcode.code_53;
class Solution{
    public static void main(String[] args) {
        int res = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
    public static int maxSubArray(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int curSum= nums[0];
        int maxSum = 0;
        for(int i = 1; i < nums.length; i++){
            if(curSum < 0){
                curSum = nums[i];
            }else{
                curSum += nums[i];
            } 
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}