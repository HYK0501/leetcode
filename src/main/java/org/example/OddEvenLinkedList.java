package org.example;

public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode oddEvenList(ListNode head) {
        if( head == null) return null;
        if( head.next == null) return head;
        ListNode oddHead = head;
        ListNode oddEnd = head;
        ListNode evenHead = head.next;
        ListNode evenEnd = head.next;
        int index = 3;
        ListNode temp = evenHead.next;
        while( temp!=null ){
            if( index %2 == 1){
                oddEnd.next = temp;
                oddEnd = oddEnd.next;
            }else{
                evenEnd.next = temp;
                evenEnd = evenEnd.next;
            }
            temp = temp.next;
            oddEnd.next = null;
            evenEnd.next = null;
            index++;
        }

        oddEnd.next = evenHead;
        return oddHead;
    }
}
