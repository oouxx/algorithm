package com.wxx.leetcode.code_93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 把这个问题抽象化可以解释为一个字符串被分割成k段，求出所有分法问题
     * 每一段的要求是长度1-3，不能以0开头。 
     * @param s
     * @return
     */
    public static void main(String[] args) {
        List<String> res = new ArrayList<String>();
        Solution obj = new Solution();
        String s = "220525511221";
        res = obj.restoreIpAddresses(s);
        System.out.println(res);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> combinations = new ArrayList<>();
        if(s == null || s.length() == 0){
            return combinations;
        }
        doCombination(0 , new StringBuilder(), s, combinations);
        return combinations;
    }
    private void doCombination(int k, StringBuilder address, String s, List<String> combinations){
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                combinations.add(address.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.valueOf(part) <= 255) {
                if (address.length() != 0) {
                    part = "." + part;
                }
                address.append(part);
                doCombination(k + 1, address, s.substring(i + 1), combinations);
                address.delete(address.length() - part.length(), address.length());
            }
        }
    }
}