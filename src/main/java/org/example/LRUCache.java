package org.example;

import java.util.*;

public class LRUCache {

    public class LinkNode{
        public int key;
        public int value;
        public LinkNode pre = null;
        public LinkNode post = null;
        LinkNode(int key ,int value ){
            this.value = value;
            this.key = key;
        }

    }
    int capacity ;
    LinkNode head = null;
    LinkNode tail = null;

    private void addNode( LinkNode node ){
        if( head == null ){
            tail = node;
        }else{
            head.pre = node;
            node.post = head;
        }
        head = node;
    }

    private void moveToHead(LinkNode node){
        if( !node.equals(head) ){
            LinkNode pre = node.pre;
            LinkNode post = null;
            if(node.post != null ) {
                post = node.post;
                post.pre = pre;
            }
            pre.post = post;
            node.pre = null;node.post=null;
            if(tail.equals(node)) tail = pre;
            addNode( node );
        }
    }

    private LinkNode removeLast( ){
        if( tail != null){
            LinkNode remove = tail;
            tail = tail.pre;
            if( tail == null ) head = null;
            else tail.post = null;
            remove.pre = null;
            return remove;
        }
        return null;
    }

    HashMap<Integer , LinkNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(  map.get(key)!=null ) moveToHead( map.get(key) );
        else return -1;
        return map.get(key).value;
    }

    public void put(int key, int value) {
        LinkNode node = map.get(key);
        if( node == null ) {
            node = new LinkNode( key , value );
            addNode( node );
        }else node.value = value;
        map.put( key , node );
        if( map.keySet().size() > capacity){
            LinkNode last = removeLast();
            //System.out.println( last.key );
            map.remove( last.key );
        }else{
            moveToHead( node );
        }
    }
}
