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
        ListNode res = null;ListNode resTail = null;
        while( l1!=null || l2!=null){
            int l1Num = 0;int l2Num = 0;
            if( l1!= null){
                l1Num = l1.val;l1=l1.next;
            }
            if( l2!= null){
                l2Num = l2.val;l2=l2.next;
            }
            int sum = l1Num + l2Num + carry;
            carry = sum/10;
            ListNode listNode = new ListNode( sum%10 );
            if( res == null){
                res = listNode;resTail=res;
            }else{
                resTail.next = listNode;
                resTail = resTail.next;
            }
        }
        if( carry != 0){
            ListNode listnode = new ListNode(carry);
            resTail.next = listnode;
        }
        return res;
    }
}
