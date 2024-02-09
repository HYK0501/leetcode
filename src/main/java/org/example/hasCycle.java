package org.example;

import java.util.ArrayList;

public class hasCycle {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
   public boolean hasCycle(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        if( head != null){
            nodes.add(head);
        }else{
            return false;
        }
        while( head.next != null ){
            if( !nodes.contains( head.next ) ){
                System.out.println( head.next.val );
                nodes.add( head.next );
            }else{
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
