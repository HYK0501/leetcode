package org.example;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minClose = 30001;
        int res = -1;
        Arrays.sort( nums );
        for( int i = 0 ; i < nums.length ; i++ ){
            int low = i; int up = nums.length-1;
            while( low > up ){
                int temp = nums[low] + nums[up] + nums[i];
                if( Math.abs( temp - target ) < minClose ){
                    minClose = Math.abs( temp - target );
                    res = temp;
                }
                if( temp > target ) up--;
                else if( temp < target ) low++;
                else return temp;
            }
        }
        return res;
    }
    //這個方法會對 你已用數學証一次 假設一個位置它就是最小出現點 依照他是大於 或 小於 target 假設 我們一定會算到那個點 不會疏漏
}
