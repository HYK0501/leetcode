package org.example;

import java.util.ArrayList;

public class RemoveNthNodeFromEndofList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        if( n == 1){
            if( list.size() > 1 ) {
                ListNode temp = list.get( list.size() -2 );
                temp.next = null;
            }
            else head = null;
        }else if( n == list.size() ){
            head = head.next;
        }else{
            ListNode temp = list.get( list.size() - n - 1  );
            ListNode next = list.get(  list.size() - n + 1 );
            temp.next = next;
        }
        return head;
    }
}
