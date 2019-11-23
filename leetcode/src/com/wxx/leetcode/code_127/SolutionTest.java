package com.wxx.leetcode.code_127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class SolutionTest{
    public static void main(String[] args){
        SolutionTest st = new SolutionTest();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int res = st.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<String>();
        set.add(beginWord);
        queue.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            while(size-- > 0){
                String curWord = queue.poll();
                for(int i = 0; i < wordList.size(); i++){
                    String nextWord = wordList.get(i);
                    if(set.contains(nextWord)){
                        continue;
                    }
                    if(oneCharDiff(curWord, nextWord)){
                        queue.add(nextWord);
                        set.add(nextWord);
                        if(nextWord == endWord){
                            return level;
                        }
                    }
                }
            } 
        }
        return 0;
    }
    public boolean oneCharDiff(String oneWord, String nextWord){
        if(oneWord.length() != nextWord.length()){
            return false;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < oneWord.length()){
            if(oneWord.charAt(i) != nextWord.charAt(j)){
                count++;
            }
            i++;
            j++;
        }
        if(count == 1){
            return true;
        }
        return false;
    }
}