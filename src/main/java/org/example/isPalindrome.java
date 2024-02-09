package org.example;

import java.util.ArrayList;

public class isPalindrome {
    public static void main(String[] args){
        System.out.println( isPalindrome(",'6``c4i,::,i4ckk6',") );
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();
        System.out.println(s);
        //ArrayList<Character> statck = new ArrayList<>();
        //ArrayList<Character> queue = new ArrayList<>();
        String s1 = null;
        String s2 = null;
        if( s.length() % 2 == 1 ){
            s1 = s.substring(0 , s.length()/2  );
            s2 = s.substring( s.length()/2 + 1  , s.length()  );
        }else{
            s1 = s.substring(0 , s.length()/2  );
            s2 = s.substring( s.length()/2  , s.length()  );
        }
        StringBuilder builder = new StringBuilder();
        builder.append(s2);
        s2 = builder.reverse().toString();
        if(s1.equals(s2)){
            return  true;
        }
        return false;
    }
}
