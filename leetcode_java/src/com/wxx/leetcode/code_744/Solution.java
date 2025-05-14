package com.wxx.leetcode.code_744;
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char res = s.nextGreatestLetter(new char[]{'a', 'b', 'c'}, 'd');
        System.out.println(res);
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if (letters[mid] > target){
                h = mid - 1; 
            }else{
                l = mid + 1;
            }
        }
        return letters[0];
    }
}