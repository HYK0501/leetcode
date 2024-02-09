package org.example;

public class MergekSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        ListNode temp = null;
        while(true){
            int smallNodeIndex = -1;
            for(int i = 0 ; i < lists.length ; i++){
                if( lists[i] != null ){
                    if( smallNodeIndex == -1 ) smallNodeIndex = i;
                    else{
                        if( lists[smallNodeIndex].val > lists[i].val ) smallNodeIndex = i;
                    }
                }
            }
            if( smallNodeIndex == -1 ) break;
            else if( res == null) {
                res = lists[smallNodeIndex];
                temp = res;
            } else {
                temp.next = lists[smallNodeIndex];
                temp = temp.next;
            }
            lists[smallNodeIndex] = lists[smallNodeIndex].next;
            temp.next = null;
        }
        return res;
    }
}
