package com.wxx.leetcode.code_91;
class Solution{
    public int numDecodings(String s){
        int strLength = s.length();
        if(s == null || strLength == 0){
            return 0;
        }
        // attention '0'
        int[] dp = new int[strLength + 1];
        dp[0] = 1; // not 0 is 1
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= strLength; i++){
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if(two <= 26){
                dp[i] = dp[i -2];
            }
        }
        return dp[strLength];
    }
}