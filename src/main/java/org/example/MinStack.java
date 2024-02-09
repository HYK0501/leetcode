package org.example;

import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> mimHistory;
    public MinStack() {
        stack = new LinkedList<>();
        mimHistory = new LinkedList<>();
    }

    public void push(int val) {
        stack.add(val);
        if( mimHistory.isEmpty() ){
            mimHistory.add( val );
        }else if( mimHistory.getLast() > val ){
            mimHistory.add(val);
        }
    }

    public void pop() {
        int val = stack.removeLast();
        //if( !mimHistory.isEmpty()){
        if( val == mimHistory.getLast() ){
            mimHistory.removeLast();
        }
        //}

    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return mimHistory.getLast();
    }
}
