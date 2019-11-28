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
        List<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12)
            return res;
        dfs(s, "", res, 1);
        return res;
    }
 
	public void dfs(String s, String temp, List<String> res, int count) {
		if (count == 4 && isValid(s)) {
			res.add(temp + s);
			return;
		}
		// Math.min(4, s.length())后面几位少于4的情况比如，0000
		for (int i = 1; i < Math.min(4, s.length()); i++) {
			String cur = s.substring(0, i);
			if (isValid(cur)) {
				// i 是beginIndex
				dfs(s.substring(i), temp + cur + ".", 
						res, count + 1);
			}
		}
	}
 
	public boolean isValid(String s) {
		// 前导0，如果第一个字符是0，只能一个为0
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return 0 < num && num < 256;
	}
}