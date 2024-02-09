package org.example;

import java.util.HashMap;

public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> map = new HashMap<>();
        for( int i = 0 ; i < ransomNote.length() ; i++){
            char cha = ransomNote.charAt(i);
            if( !map.keySet().contains( cha ) ){
                map.put(  cha , 1);
            }else{
                int num = map.get( cha );
                map.replace(cha , num + 1);
            }
        }

        for( int i = 0 ; i < magazine.length() ; i++){
            char cha = magazine.charAt(i);
            if( map.keySet().contains( cha ) ){
                int num = map.get( cha );
                if( num != 0){
                    map.replace(cha , num - 1 );
                }
            }
        }
        for( Character character : map.keySet() ){
            if( map.get(character) != 0 ){
                return false;
            }
        }
        return true;
    }
}
