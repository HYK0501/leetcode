package org.example;

import java.util.List;

public class RotateList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    ListNode tail1;
    ListNode head2;
    public void reverse(ListNode head , ListNode tail ){
        ListNode temp = null;ListNode nextTemp = null;
        if( !head.equals(tail) ) {
            temp = head; nextTemp = head.next;
        }
        while( temp != null && nextTemp != null ){
            ListNode tempTemp = nextTemp;
            if( temp.next != null){
                nextTemp = nextTemp.next;
                tempTemp.next = temp;
                if(temp.equals(head)) temp.next = null;
                temp = tempTemp;
            }
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;int num = 0;ListNode tail = head;int total = 0;
        while( temp != null){
            total++;
            if(temp.next!=null) temp = temp.next;
            else {
                tail = temp;
                break;
            }
        }
        if( head==null ) return head;
        if( k%total != 0 ) {
            reverse( head  , tail);
            temp = tail;
            while( temp != null){
                num++;
                if( num == k%total ){
                    ListNode next = temp.next;
                    temp.next = null;
                    if( next != null ) reverse( next  , head);
                    reverse( tail  , temp );
                    tail.next = head;
                    break;
                }
                temp = temp.next;
            }
            return temp;
        }else{
            return head;
        }
    }
}
