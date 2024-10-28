package org.example;

public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void remove( ListNode preNode , ListNode node , ListNode next ){
        node.next = null;
        preNode.next = next;
    }

    public void insert( ListNode preNode , ListNode node ){
        ListNode next = preNode.next;
        preNode.next = node;
        node.next = next;
    }
    public ListNode oddEvenList(ListNode head) {
        ListNode oddTail = head;
        ListNode preNode = head != null ? head.next : null;
        ListNode node = preNode != null ? preNode.next : null;
        while( node != null ){
            remove( preNode , node , node.next);
            insert( oddTail , node );
            oddTail = oddTail.next;
            preNode = preNode.next;
            node = preNode != null ? preNode.next : null;
        }
        return head;
    }
}
