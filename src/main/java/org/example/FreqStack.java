package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FreqStack{
    public class pair{
        int freq;
        int num;
        int top;
        public pair(int freq , int num , int top){
            this.freq = freq;
            this.num = num;
            this.top = top;
        }
        @Override
        public boolean equals(Object obj) {
            if( obj instanceof  FreqStack ){
                if( ( ((pair) obj).freq ) == freq && ((pair) obj).num == num ) return true;
            }
            return false;
        }
    }
    int top = 0;
    PriorityQueue<pair> maxHeap;
    HashMap<Integer , Integer> numToFreq;

    public FreqStack() {
        maxHeap = new  PriorityQueue<pair>( ( (p1, p2) -> {
            if( p1.freq != p2.freq ) return p2.freq - p1.freq;
            else return p2.top - p1.num;
            } )
        );
        numToFreq = new HashMap<>();
    }

    public void push(int val) {
        top++;
        Integer freq = numToFreq.get(val);
        if( freq==null ){
            numToFreq.put( val , 1 );
            maxHeap.add( new pair( 1 , val , top) );
        }else{
            numToFreq.put( val , freq + 1);
            maxHeap.remove( new pair( freq , val , top)  );
            maxHeap.add( new pair( freq+1 , val , top) );
        }
    }

    public int pop() {
        pair p = maxHeap.poll();
        int freq = numToFreq.get( p.num );
        if( freq == 1 ) numToFreq.remove( p.num );
        else numToFreq.put( p.num , freq-1);
        return p.num;
    }

}
