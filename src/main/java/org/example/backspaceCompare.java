package org.example;

public class backspaceCompare {

    public static String replace(String s){
        int charPlace = -1;
        //int shotPlace = ;
        StringBuilder stringBuilder = new StringBuilder(s);
        for( int i = 0 ; i < s.length() ; i++){
            if( s.charAt(i) != '#'){
                charPlace ++;
                if( charPlace != i){
                    char ichar = stringBuilder.charAt(i);
                    char jchar =  stringBuilder.charAt(charPlace);
                    stringBuilder.setCharAt( i , jchar);
                    stringBuilder.setCharAt( charPlace , ichar);
                }
            }else{
                if( charPlace > -1){
                    stringBuilder.setCharAt( charPlace , '#' );
                    charPlace--;
                }
            }
        }
        return stringBuilder.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        s = replace(s);
        t = replace(t);
        //System.out.println( s );
        //System.out.println( t );
        int index = 0;
        try {
            while( s.charAt(index) != '#' || t.charAt(index) != '#' ){
                if( s.charAt(index) != t.charAt(index) ){
                    return false;
                }
                index++;
            }
        }catch(StringIndexOutOfBoundsException e){
            if( s.length() > t.length() ){
                if( s.charAt(index) != '#' ){
                    return false;
                }
            }else{
                if( t.charAt(index) != '#' ){
                    return false;
                }
            }
        }

        return true;
    }
}
