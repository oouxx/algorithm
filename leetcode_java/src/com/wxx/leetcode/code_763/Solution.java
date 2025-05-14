package com.wxx.leetcode.code_763;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int p = 0;
        int prep = -1;
        List<Integer> res = new ArrayList<>();
        for(int cur = 0; cur < S.length(); cur++){
            int newp = S.indexOf(S.charAt(cur), p + 1);
            p = newp == -1 ? p : newp;
            if(cur == p){
                res.add(p - prep);
                prep = p;
                p++;
            }
        } 
        return res;
    }
}