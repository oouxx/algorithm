package com.wxx.leetcode.code_435;

import java.util.Arrays;
import java.util.Comparator;
/**
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int intervalsLength = intervals.length;
        if(intervalsLength == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] obj1, int[] obj2){
                return obj1[1] - obj2[1];
            }
        });
        int end = intervals[0][1];
        int counter = 1;
        for(int i = 1; i < intervalsLength; i++){
            if(intervals[i][0] < end){
                continue;
            }
            end = intervals[i][1];
            counter++;
        }
        return intervalsLength - counter;
    }
        
}
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int intervalsLength = intervals.length;
        if(intervalsLength == 0){
            return 0;
        };
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int end = intervals[0][1];
        int counter = 1;
        for(int i = 1; i < intervalsLength; i++){
            if(intervals[i][0] < end){
                continue;
            }
            end = intervals[i][1];
            counter++;
        }
        return intervalsLength - counter;
    }
        
}