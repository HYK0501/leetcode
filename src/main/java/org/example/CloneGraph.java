package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public void copy(Node originNode  ,Node node , Map<Node , Node> cloneMap){
        Set<Node> set = node.neighbors.stream().collect(Collectors.toSet());
        for( Node neigh : originNode.neighbors ){
            Node neighCopy = null;
            if( cloneMap.get(neigh) == null ){
                neighCopy = new Node( neigh.val );
                cloneMap.put( neigh , neighCopy);
            }else{
                neighCopy = cloneMap.get( neigh );
            }
            if( !set.contains(neighCopy) ){
                node.neighbors.add( neigh );
                neighCopy.neighbors.add( node );
            }
        }

        for( Node neigh : originNode.neighbors ){
            Node neighCopy = cloneMap.get( neigh );
            if( !set.contains(neighCopy) ){
                copy( neigh , neighCopy , cloneMap );
            }
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node , Node> cloneMap = new HashMap<>();
        if( node == null){
            return null;
        }
        else if( node.neighbors.isEmpty() ){
            return new Node();
        }
        Node nodeCopy = new Node( node.val );
        cloneMap.put(node , nodeCopy);
        for( Node neigh : node.neighbors ){
            Node neighCopy = null;
            if( cloneMap.get(neigh) == null ){
                neighCopy = new Node( neigh.val );
                cloneMap.put( neigh , neighCopy);
            }else{
                neighCopy = cloneMap.get( neigh );
            }
            nodeCopy.neighbors.add( neighCopy );
            neighCopy.neighbors.add( nodeCopy );
        }

        for( Node neigh : node.neighbors ){
            Node neighCopy = cloneMap.get( neigh );
            copy( neigh , neighCopy , cloneMap );
        }
        return nodeCopy;
    }
}
