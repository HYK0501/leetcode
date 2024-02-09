package org.example;

public class SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class subList{
        ListNode head;
        ListNode tail;
        subList() {}
        subList( ListNode head , ListNode tail){
            this.head = head;
            this.tail = tail;
        }
    }

    public ListNode getMiddle(ListNode head){
        ListNode middle = null;
        if( head.next.next == null){  middle = head.next; head.next = null; }
        else{
            ListNode slow = head.next; ListNode fast = head.next.next;ListNode preNode = head;
            while( fast != null){
                if( fast.next == null)break;
                else{
                    fast = fast.next.next;
                    preNode = slow;
                    slow = slow.next;
                }
            }
            preNode.next = slow.next;
            slow.next = null;
            middle = slow;
        }
        return middle;
    }

    public subList sort( ListNode head ){
        if( head == null) return new subList(null , null);
        if( head.next == null){
            return new subList( head , head );
        }else{
            ListNode bigHead = null; ListNode bigTail = null; ListNode smallHead = null; ListNode smallTail = null;
            ListNode middle = getMiddle(head);
            ListNode temp = head;
            while( temp != null ){
                if( temp.val >= middle.val ){
                    if( bigHead == null){
                        bigHead = temp;bigTail=temp;
                    }else{
                        bigTail.next = temp; bigTail = bigTail.next;
                    }
                    temp = temp.next;
                    bigTail.next = null;
                }else{
                    if( smallHead == null ){
                        smallHead = temp;smallTail = temp;
                    }else{
                        smallTail.next = temp; smallTail = smallTail.next;
                    }
                    temp = temp.next;
                    smallTail.next = null;
                }
            }
            subList bigList = null; subList smallList = null;subList newList = new subList( head , head );
            if( smallHead != null){
                smallList = sort( smallHead );
                smallList.tail.next = middle;
                newList.head = smallList.head;
            }
            if( bigHead != null){
                bigList = sort( bigHead );
                middle.next = bigList.head;
                newList.tail = bigList.tail;
            }
            return newList;
        }
    }


    public ListNode sortList(ListNode head) {
        subList res = sort( head );
        return res.head;
    }
}
