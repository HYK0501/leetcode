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

    Node[] nodes;

    public void dfs( Node node , Node originNode){
        nodes[ node.val - 1 ] = node;
        for( Node child : originNode.neighbors ){
            Node newNode = nodes[ child.val - 1 ];
            if( newNode == null ) {
                newNode = new Node( child.val );
                dfs( newNode , child );
            }
            node.neighbors.add( newNode );
        }
    }


    public Node cloneGraph(Node node) {
        nodes = new Node[100];
        Node root = null;
        if( node != null ) root = new Node(node.val);
        else return node;
        dfs( root , node );
        return root;
    }
}
