package org.example;

public class SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void connect( ListNode preNode , ListNode[] sub ){
        preNode.next = sub[0];
        sub[0] = sub[0].next;
    }
    //java 的參數是傳 ref 的 copy basic type just value copy
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while( temp!=null ){
            temp = temp.next;
            len++;
        }
        ListNode dummy = new ListNode( -1 , head );
        for( int step = 1 ; step < len ; step=step*2 ){
            ListNode preNode = dummy;
            ListNode next = dummy.next;
            while( next!=null ){
                ListNode[] subOne = new ListNode[2];
                ListNode[] subTwo = new ListNode[2];

                for( int i = 0 ; i < 2 ; i++){
                    int subLen = 0;
                    if( i==0 ) subOne[0] = next;
                    else subTwo[0] = next;
                    while( next!= null && subLen < step ){
                        subLen++;
                        if( i==0 ) subOne[1] = next;
                        else subTwo[1] = next;
                        next = next.next;
                    }
                }
                if( subOne[1] != null ) subOne[1].next = null;
                if( subTwo[1] != null ) subTwo[1].next = null;
                //System.out.println( subTwo[0].val );
                while( subOne[0] != null && subTwo[0] != null ){
                    if( subOne[0].val < subTwo[0].val ) connect( preNode , subOne );
                    else connect( preNode , subTwo );
                    preNode = preNode.next;
                    preNode.next = null;
                }
                if( subOne[0] != null ){
                    preNode.next = subOne[0];
                    preNode = subOne[1];
                }else{
                    preNode.next = subTwo[0];
                    preNode = subTwo[1];
                }
            }
        }
        return dummy.next;
    }
}
