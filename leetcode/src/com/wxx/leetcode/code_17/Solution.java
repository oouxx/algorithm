package com.wxx.leetcode.code_17;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] KEYS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};       
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>(); //把中间所走过的路全部记录下来
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        doCombination(new StringBuilder(), combinations, digits);
        return combinations;
    }

    // DFS思想
    // 以下用递归也可以用栈
    private void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length()) - '0';
        String letters = KEYS[curDigits];
        for (char c : letters.toCharArray()) {
            prefix.append(c);                         // 添加
            doCombination(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1); // 删除
        }
    }
}