package org.example;

public class middleNode {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode middleNode(ListNode head) {
        ListNode iterator = head;
        ListNode middle = null;
        int index = 0;
        while( iterator != null){
            iterator = iterator.next;
            index ++;
            if( index%2 == 0){
                if( middle == null){
                    middle = head;
                }else{
                    middle = middle.next;
                }
            }
        }
        if( middle != null && middle.next != null){
            middle = middle.next;
        }else if( head != null && head.next == null ){
            middle = head;
        }
        return middle;
    }
}
