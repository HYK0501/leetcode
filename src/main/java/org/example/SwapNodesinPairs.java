package org.example;

public class SwapNodesinPairs {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode swap( ListNode node , ListNode next , ListNode next2 ){
    if( node == null ) return node;
    else if( next == null ) return node;
    else{
      next.next = node;
      node.next = next2;
      return next;
    }
  }
  public ListNode swapPairs( ListNode head ) {
    ListNode next = head != null ? head.next : null;
    ListNode next2 = next != null ? next.next : null;
    head = swap( head , next , next2 );
    ListNode preNode = head != null ? head.next : null;
    while( next2 != null ){
      //after swap the order is next -> node -> next2
      ListNode node = next2;
      next = node.next;
      next2 = next != null ? next.next : null;
      preNode.next = swap( node , next , next2 );
      preNode = preNode.next.next;
    }
    return head;
  }
}
