package com.wxx.leetcode.code_452;

import java.util.Arrays;
import java.util.Comparator;

class Solution{
    public int findMinArrowShots(int[][] points) {
        int pointsLength = points.length;
        if(pointsLength <= 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] obj1, int[] obj2){
                return obj1[1] - obj2[1];
            }
        });
        int counter = 1;
        int end = points[0][1];
        for(int i = 1; i < pointsLength; i++){
            if(points[i][0] <= end){
                continue;
            }
            counter++;
            end = points[i][1];
        }
        return counter;
    }
}