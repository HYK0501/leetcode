package org.example;

import java.util.ArrayList;

public class ReverseNodesinKGroup {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }


    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        while( temp != null ){
            nodes.add( temp );
            ListNode preTemp = temp;
            temp = temp.next;
            preTemp.next = null;
        }
        for( int i = k-1 ; i < nodes.size() ; i = i + k){
            ListNode node = nodes.get(i);
            for( int j = i ; j > i - k + 1 ; j -- ){
                node.next = nodes.get( j - 1 );
                node = node.next;
            }
            if( i + k < nodes.size() ) node.next = nodes.get( i + k );
            else{
                for( int j = i + 1 ; j < nodes.size() ; j++){
                    node.next = nodes.get(j);
                    node = node.next;
                }
            }
        }
        return nodes.get( k - 1 );
    }
}
