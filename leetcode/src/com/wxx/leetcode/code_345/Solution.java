package com.wxx.leetcode.code_345;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	private final static HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
    	if (s == null) {
    		return null;
    	}
    	String ss = s;
		int ssLength = ss.length();
		char[] result = new char[ssLength];
		int i = 0;
		int j = ssLength - 1;
		while (i <= j) {
			char ci = ss.charAt(i);
			char cj = ss.charAt(j);
			if(!vowels.contains(ci)) {
				result[i++] = ci;
			}else if(!vowels.contains(cj)) {
				result[j--] = cj;
			}else {
				result[i++] = cj;
				result[j--] = ci;
			}
		}
		return new String(result);
    }
}
