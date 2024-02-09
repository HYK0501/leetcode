package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class evalRPN {
    public int evalRPN(String[] tokens) {
        HashSet<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0 ; i < tokens.length ; i++){
            if( operations.contains( tokens[i] )){
                if( tokens[i].equals("+") ){
                    int right = stack.removeLast();
                    int left = stack.removeLast();
                    int sum = left + right;
                    stack.addLast(sum);
                }else if( tokens[i].equals("-") ){
                    int right = stack.removeLast();
                    int left = stack.removeLast();
                    int sum = left - right;
                    stack.addLast(sum);
                }else if( tokens[i].equals("*") ){
                    int right = stack.removeLast();
                    int left = stack.removeLast();
                    int sum = left * right;
                    stack.addLast(sum);
                }else if( tokens[i].equals("/") ){
                    int right = stack.removeLast();
                    int left = stack.removeLast();
                    int sum = left / right;
                    stack.addLast(sum);
                }
            }else{
                int num = Integer.getInteger( tokens[i] );
                stack.addLast( num );
            }
        }
        return stack.removeLast();
    }
}
