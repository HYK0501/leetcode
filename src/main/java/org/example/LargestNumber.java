package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numsStrs = new String[nums.length];
        boolean allZero = true;
        for(int i = 0 ; i < nums.length ; i++){
            numsStrs[i] = Integer.toString( nums[i] );
            if( nums[i] != 0) allZero = false;
        }
        if( allZero ) return "0";
        Arrays.sort( numsStrs, new Comparator<String>() {
            public int compare(String o1,String o2) {
                int index = 0;
                StringBuilder sb1 = new StringBuilder( o1 );
                sb1.append(o2);
                StringBuilder sb2 = new StringBuilder( o2 );
                sb2.append(o1);
                o1 = sb1.toString();
                o2 = sb2.toString();
                while( index < o1.length()  ){
                    if( o1.charAt(index) != o2.charAt(index) ) return o1.charAt(index) - o2.charAt(index);
                    index ++;
                }
                return -1;
            }
        });
        StringBuilder res = new StringBuilder();
        for(int i = numsStrs .length - 1 ; i > -1 ; i--) res.append( numsStrs [i] );
        return res.toString();
    }
}
