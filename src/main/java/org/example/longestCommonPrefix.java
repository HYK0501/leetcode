package org.example;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs){
        String prefix = strs[0];
        for( int i=0 ; i < strs.length ; i++){
            StringBuilder tempPrefix = new StringBuilder();
            for( int j = 0 ; j < prefix.length() ; j++ ){
                if( prefix.charAt( j ) == strs[i].charAt(j) ){
                    tempPrefix.append( prefix.charAt( j ) );
                }else{
                    break;
                }
            }
            prefix = tempPrefix.toString();
            if( prefix.equals("") ){
                break;
            }
        }
        return prefix;
    }
}
