package org.example;

public class mergeTwoLists {
    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode headNode = null;
        ListNode tailNode = null;
        while( list1!=null || list2!=null ){
            if( list1!=null && list2!=null){
                if(list1.val <= list2.val ){
                    ListNode listNode = new ListNode( list1.val );
                    if( tailNode == null ){
                        headNode = listNode;
                    }else{
                        tailNode.next = listNode;
                    }
                    tailNode = listNode;
                    list1 = list1.next;
                }else{
                    ListNode listNode = new ListNode( list2.val );
                    if( tailNode == null ){
                        headNode = listNode;
                    }else{
                        tailNode.next = listNode;
                    }
                    tailNode = listNode;
                    list2 = list2.next;
                }
            }
            else if( list1==null){
                ListNode listNode = new ListNode( list2.val );
                if( tailNode == null ){
                    headNode = listNode;
                }else{
                    tailNode.next = listNode;
                }
                tailNode = listNode;
                list2 = list2.next;
            }
            else if( list2 == null ){
                ListNode listNode = new ListNode( list1.val );
                if( tailNode == null ){
                    headNode = listNode;
                }else{
                    tailNode.next = listNode;
                }
                tailNode = listNode;
                list1 = list1.next;
            }
        }
        return headNode;
    }
}
