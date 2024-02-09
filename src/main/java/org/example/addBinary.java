package org.example;

public class addBinary {
    public String addBinary(String a, String b) {

        String up = null;
        String lower = null;
        if( a.length() > b.length()){
            up = a;
            lower = b;
        }else{
            lower = a;
            up = b;
        }
        StringBuilder builder = new StringBuilder();
        builder.append( lower );
        while( lower.length() != up.length() ){
            builder.insert( 0  , "0");
            lower = builder.toString();
        }
        StringBuilder resBuilder = new StringBuilder();
        int carry = 0;
        for(int i = up.length()-1 ; i >=0 ; i-- ){
            int upint = Integer.parseInt( up.substring( i , i+1 ) );
            int lowerint = Integer.parseInt( lower.substring( i , i+1 ) );
            int sum = upint + lowerint + carry;
            if( sum >= 2 ){
                carry = 1;
            }else{
                carry = 0;
            }
            int digit = sum%2;
            resBuilder = resBuilder.insert( 0 , String.valueOf(digit) );
        }
        if( carry != 0){
            resBuilder = resBuilder.insert( 0 ,"1" );
        }
        return resBuilder.toString();
    }
}
