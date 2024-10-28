package org.example;

import java.util.HashMap;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        s = "#" + s.replaceAll("" , "#") + "#";
       int center = 0;
       int right = 0;
       int max = 0;
       String res = "";
       int[] dp = new int[ s.length() ];
       for( int i = 0 ; i < s.length() ; i++ ){
           if( i < right ){
               dp[i] = Math.min( right - i  , dp[2*center - i ]);
           }
           while( i - dp[i] - 1 > -1 && i + dp[i] + 1 < s.length() && ( s.charAt( i + dp[i] + 1 ) == s.charAt( i - dp[i] - 1 ))  ){
               dp[i]++;
           }
           if( i + dp[i] > right ){
               center = i;
               right = center + dp[i];
           }
           if( max < dp[i] ){
               max = dp[i];
               res = s.substring( center - dp[i] , center + dp[i] + 1 ).replaceAll("#" , "");
           }
       }
        return res;
    }
}
