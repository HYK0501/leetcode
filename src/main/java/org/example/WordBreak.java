package org.example;

import java.util.*;

public class WordBreak {

        public boolean wordBreakSub( int stringLen , Map<Integer , Set<Integer> > gaps , int start){
            Set<Integer> ends = gaps.get( start );
            if( ends == null){
                return false;
            }else{
                for( Integer end : ends ){
                    if( end == stringLen ){
                        return true;
                    }else{
                        boolean res = wordBreakSub( stringLen , gaps , end + 1 );
                        if( res ){
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        public boolean wordBreak(String s, List<String> wordDict) {
            Map<Integer , Set<Integer> > gaps = new HashMap<>();
            int len = s.length();
            for(String word : wordDict){
                int start = 0;
                while( start < len){
                    int wordEnd = start + word.length() - 1;
                    if( wordEnd > len - 1){
                        break;
                    }
                    else if( s.substring( start , wordEnd + 1 ).equals( word ) ){
                        //System.out.println( wordEnd );
                        if( gaps.containsKey( start ) ){
                            gaps.get( start ).add( wordEnd );
                        }else{
                            HashSet<Integer> set = new HashSet<>();
                            set.add( wordEnd );
                            gaps.put( start , set);
                            //System.out.println( wordEnd );
                        }
                    }//else{
                    //System.out.println( s.substring( start , wordEnd ) );
                    start ++;
                    //}
                }
            }

            for( int i = 0 ; i < s.length() ; i++){
                boolean lost = true;
                for( Integer start : gaps.keySet() ){
                    boolean out = false;
                    for( Integer end : gaps.get( start ) ){
                        if( start <= i && i <= end  ){
                            Set<Integer> set = gaps.get( end + 1 );
                            if( set != null){
                                out = true;
                                break;
                            }else if( end == s.length() - 1 ){
                                out = true;
                                break;
                            }
                        }
                    }
                    if( out ){
                        lost = false;
                        break;
                    }
                }
                if( lost ){
                    System.out.println(i);
                    System.out.println("lost");
                    return false;
                }
            }

            return wordBreakSub( s.length() - 1 , gaps , 0);
        }

}
