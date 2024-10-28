package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ContainMostWater {
    public int maxArea(int[] height) {
        int left = 0; int right = height.length-1; int max = 0;
        while( left < right ){
            max = Math.max( max , (right - left)* Math.min( height[left] ,  height[right]) );
            if( height[left] > height[right]  ) right--;
            else left++;
        }
        return max;
    }

}
