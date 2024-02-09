package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    public List<StringBuilder> build( int index , String digits , Map<Character , List<String>> map ){
        List<StringBuilder> result = new ArrayList<>();
        if( index == digits.length() - 1 ){
            List<String> numbers = map.get( digits.charAt( index ) );
            for(String number : numbers){
                StringBuilder builder = new StringBuilder();
                result.add( builder.append( number ) );
            }
        }else{
            List<String> numbers = map.get( digits.charAt( index ) );
            List<StringBuilder> tempRes = build( index + 1 , digits , map);
            for( String number : numbers ){
                for( StringBuilder temp : tempRes){
                    StringBuilder sb = new StringBuilder(number);
                    sb.append(temp);
                    result.add(sb);
                }
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if(  digits.length() == 0){
            List<String> result = new ArrayList<>();
            return result;
        }
        Map<Character , List<String>> map = new HashMap<>();
        List<String> two = new ArrayList<>();
        two.add( "a" );
        two.add( "b" );
        two.add( "c" );
        List<String> three = new ArrayList<>();
        three.add( "d" );
        three.add( "e" );
        three.add( "f" );
        List<String> four = new ArrayList<>();
        four.add( "g" );
        four.add( "h" );
        four.add( "i" );
        List<String> five = new ArrayList<>();
        five.add( "j" );
        five.add( "k" );
        five.add( "l" );
        List<String> six = new ArrayList<>();
        six.add( "m" );
        six.add( "n" );
        six.add( "o" );
        List<String> seven = new ArrayList<>();
        seven.add( "p" );
        seven.add( "q" );
        seven.add( "r" );
        seven.add( "s" );
        List<String> eight = new ArrayList<>();
        eight.add( "t" );
        eight.add( "u" );
        eight.add( "v" );
        List<String> nine = new ArrayList<>();
        nine.add( "w" );
        nine.add( "x" );
        nine.add( "y" );
        nine.add( "z" );
        map.put( '2' , two );
        map.put( '3' , three );
        map.put( '4' , four );
        map.put( '5' , five );
        map.put( '6' , six );
        map.put( '7' , seven );
        map.put( '8' , eight );
        map.put( '9' , nine );
        List<StringBuilder> sbs = build(0 , digits , map);
        List<String> result = new ArrayList<>();
        for(StringBuilder sb : sbs){
            result.add(sb.toString());
        }
        return result;
    }
}
