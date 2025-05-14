package com.wxx.leetcode.code_1143;


public class Solution {
    public static void main(String[] args){
        String text1 = "abcabc";
        String text2 = "abc";
        int res = longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }
    public static int longestCommonSubsequence(String text1, String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][];
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
