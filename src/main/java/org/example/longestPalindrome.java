package org.example;

import java.util.HashMap;

public class longestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char cha = s.charAt(i);
            if( !map.containsKey(cha) ){
                map.put(cha , 1);
            }else{
                int num = map.get(cha);
                map.replace(cha , num+1);
            }
        }
        int res = 0;
        for(Character cha : map.keySet()){
            int num = map.get(cha);
            if( num%2 == 0 ){
                res = res + num;
                map.put(cha , 0);
            }else{
                res = res + num - 1;
                map.put(cha , 1);
            }
        }

        for(Character cha : map.keySet()){
            int num = map.get(cha);
            if( num != 0){
                res = res + 1;
            }
        }
        return res;
    }
}
