package org.example;

import java.util.ArrayList;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        //int beginLocation = 0;
        int temp = 0;
        ArrayList<Character> characters = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            if( !characters.contains( s.charAt(i) ) ){
                temp++;
            }else{
                //if( temp > max ){
                boolean add = false;
                int removeLength = 0;
                ArrayList<Character> tempChars = new ArrayList<>();
                for( int j = 0 ; j < characters.size() ; j++){
                    if( add ){
                        tempChars.add( characters.get(j) );
                    }else{
                        removeLength++;
                    }
                    if( characters.get(j).equals( s.charAt(i) ) ){
                        add = true;
                    }
                }
                if( temp > max ){
                    max = temp;
                }
                temp = temp - removeLength + 1;
                characters = tempChars;
            }
            characters.add( s.charAt(i) );
        }

        if( temp > max){
            //beginLocation = s.length() - temp;;
            max = temp;
        }
        return max;

    }
}
