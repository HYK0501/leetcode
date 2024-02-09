package org.example;

import java.util.ArrayList;


    class MyQueue {
        public ArrayList<Integer> queue;
        public MyQueue() {
            ArrayList<Integer> queue = new ArrayList<>();
        }

        public void push(int x) {
            this.queue.add(x);
        }

        public int pop() {
            int x = this.queue.remove(0);
            return x;
        }

        public int peek() {
            int x = this.queue.get(0);
            return x;
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

