package org.example;

import java.util.LinkedList;

public class BasicCalculatorII {
    LinkedList<Character> operations = new LinkedList<>();
    LinkedList<Integer> nums = new LinkedList<>();
    public void caculate(boolean front){
        char signal; int right,left,sum;
        if( front ) {
            signal = operations.removeFirst();left = nums.removeFirst();right = nums.removeFirst();
        }
        else {
            signal = operations.removeLast();right = nums.removeLast();left = nums.removeLast();
        }
        //System.out.println( left + "/" + right + " " + signal );
        if( signal == '+' ) sum = left + right;
        else if( signal == '-') sum = left - right;
        else if( signal == '*' ) sum = left * right;
        else sum = left/right;
        if(front)nums.addFirst(sum);
        else nums.add(sum);
    }

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if( s.charAt(i) >= '0' && s.charAt(i) <= '9') sb.append( s.charAt(i) );
            else if( s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                nums.add( Integer.parseInt( sb.toString() ) );sb = new StringBuilder();
                if(s.charAt(i) == '+' || s.charAt(i) == '-')if( !operations.isEmpty()  )if( operations.getLast() == '*' || operations.getLast() == '/' ) caculate(false);
                if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                    if( !operations.isEmpty()  )if( operations.getLast() != '+' && operations.getLast() != '-' ) caculate(false);
                }
                operations.add( s.charAt(i) );
            }
        }
        nums.add( Integer.parseInt( sb.toString() ) );
        if(!operations.isEmpty())if( operations.getLast() == '*' || operations.getLast() == '/' ) caculate(false);
        while( !operations.isEmpty() ) caculate(true);
        return nums.getLast();
    }
}
