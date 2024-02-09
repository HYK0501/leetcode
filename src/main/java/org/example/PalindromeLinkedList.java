package org.example;

import java.util.ArrayList;

public class PalindromeLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public boolean isPalindrome(ListNode head) {
       ListNode newNode = new ListNode( head.val );
       ListNode temp = head;
       while( temp != null){
         if( temp.next != null){
           newNode = new ListNode(temp.next.val , newNode);
         }
         temp = temp.next;
       }

       while( newNode!= null && head!=null ){
         if( newNode.val != head.val){
           return false;
         }
       }
       return true;
    }
}
