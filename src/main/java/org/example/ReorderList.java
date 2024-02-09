package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReorderList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public void reorderList(ListNode head) {
        if( head == null ) return;
        else if( head.next == null) return;
        else if( head.next.next == null) return;
        else{
            ListNode fast = head.next.next;
            ListNode slow = head.next;
            while( true ){
                if( fast.next == null ) break;
                else if( fast.next.next == null ) {
                    slow = slow.next;
                    break;
                }
                slow = slow.next; fast = fast.next.next;
            }
            ListNode node = head; LinkedList<ListNode> pre = new LinkedList<>(); LinkedList<ListNode> back = new LinkedList<>(); boolean isPre = true;
            while( node != null ){
                if( node == slow ){
                    if( fast.next != null )back.add(node);//is even
                    else pre.add(node);
                    isPre = false;
                }
                else if( isPre ) pre.add(node);
                else back.addFirst(node);
                ListNode temp = node;node = node.next;temp.next = null;
            }
            head = pre.peekFirst();ListNode temp = null;
            while( !pre.isEmpty() || ! back.isEmpty()){
                if( temp == null ) temp = pre.removeFirst();
                else{
                    temp.next = pre.removeFirst();temp = temp.next;
                }
                if( !back.isEmpty() ) {
                    temp.next = back.removeFirst(); temp = temp.next;
                }
            }
        }
    }
}
