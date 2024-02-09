package org.example;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    PriorityQueue<Integer> maxHeap;//left
    PriorityQueue<Integer> minHeap;//right
    public FindMedianfromDataStream() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if( maxHeap.size() == minHeap.size() ){
            if( maxHeap.size() == 0 ) maxHeap.add(num);
            else {
                int rightMin = minHeap.peek();
                if( num <= rightMin) maxHeap.add(num);
                else {
                    rightMin = minHeap.remove();
                    minHeap.add(num);
                    maxHeap.add(rightMin);
                }
            }
        }else{
            int leftMax = maxHeap.peek();
            if( leftMax <= num) minHeap.add(num);
            else{
                leftMax = maxHeap.remove();
                maxHeap.add(num);
                minHeap.add(leftMax);
            }
        }
    }

    public double findMedian() {
        if( maxHeap.size() == minHeap.size() ){
            int rightMin = minHeap.peek();
            int leftMax = maxHeap.peek();
            return (double) (rightMin+leftMax)/(double) 2;
        }else{
            return (double) maxHeap.peek();
        }
    }
}
