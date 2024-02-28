package org.example;
import java.util.List;
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for( int i = 0 ; i < s.length() ;i++ ){
            for( String word : wordDict ){
                if( i+1 < word.length() ) continue;
                else if( s.substring( i - word.length() + 1 , i+1 ).equals( word ) ) dp[i+1] = dp[i+1] || dp[i+1-word.length()];
            }
        }
        return dp[s.length()];
    }
}
