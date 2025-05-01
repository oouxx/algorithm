package com.wxx.leetcode.code_20;

import java.util.*;

public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        boolean valid = true;
        int first = 0;
        int second = n - 1;
        while (first < second) {
            if (s.charAt(first) != s.charAt(second)) {
                valid = false;
                break;
            }
            first++;
            second--;
        }
        return valid;
    }
}

class Solution1 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) { // 遇到右括号
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) { // 栈为空，或者栈顶元素与相应的左括号不匹配
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
