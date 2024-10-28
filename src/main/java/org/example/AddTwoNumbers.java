package org.example;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while( l1 != null && l2 != null ){
            ListNode temp = new ListNode( ( l1.val + l2.val + carry )%10 );
            carry = ( l1.val + l2.val + carry )/10;
            if( head == null ){
                head = temp;
                tail = temp;
            }else {
                tail.next = temp;
                tail = temp;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode node = l1 != null ? l1 : l2;
        while( node!= null || carry!= 0 ){
            int digit = node!= null ? node.val : 0;
            ListNode temp = new ListNode( ( digit  + carry )%10 );
            carry = ( digit  + carry )/10;
            tail.next = temp;
            tail = temp;
            node = node!= null ?  node.next : null;
        }
        return head;
    }
}
