package com.wxx.leetcode.code_455;
import java.util.Arrays;


class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int gi = 0;
        int si = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(gi < g.length && si < s.length){
            if(g[gi] <= s[si]){
                gi++;
            }
            si++;
        }
        return gi;
        
    }
}