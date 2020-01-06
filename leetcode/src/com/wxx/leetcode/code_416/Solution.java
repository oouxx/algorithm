package com.wxx.leetcode.code_416;

public class Solution{
    public static void main(String[] args) {
        int[] nums = {1, 5 ,5 ,11};
        boolean res = canPartition(nums);
        System.out.println(res);
    }
    public static boolean canPartition(int[] nums){
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        boolean res = canPartitionCore(nums, 0, 0, sum2);
        return res;
    }
    public static boolean canPartitionCore(int[] nums, int start, int sum1, int sum2){
        if(sum1 == sum2){
            return true;
        }
        boolean res1 = false;
        boolean res2 = false;
        for(int i = start; i < nums.length; i++){
            res1 = canPartitionCore(nums, i + 1, sum1 + i, sum2 - i);
            res2 =canPartitionCore(nums, i + 1, sum1, sum2);
        }
        return res1 || res2;
    }
}
/*
public class Solution{
    public boolean canPartition(int[] nums){
        int sum = computeArraySum(nums);
        if(sum % 2 != 0){
            return false;
        }
        int W = sum /2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        for(int num: nums){
            for(int i = W; i >= num; i--){
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }
    private int computeArraySum(int[] nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum;
    }
}
*/