package org.example;

public class SwapNodesinPairs {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs( ListNode head ) {
        if( head.next != null){
            ListNode temp = null;
            temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;
            ListNode prenode = head.next;
            ListNode node = head.next;
            while( node != null){
                if( node.next != null){
                    temp = node.next;
                    node.next = temp.next;
                    temp.next = node;
                    prenode.next = temp;
                }
                prenode = node;
                node = node.next;
            }
        }
        return head;
    }
}
