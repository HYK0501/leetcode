package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MaximumWidthofBinaryTree {
    class pair{
        TreeNode node;
        int index;
        pair(int index , TreeNode node ){
            this.index = index;
            this.node = node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<pair> list = new LinkedList<>();
        list.add( new pair( 0 , root) );
        int res = 1;
        while( !list.isEmpty() ){
            int shift = 0;
            LinkedList<pair> nextList = new LinkedList<>();
            int subOne = 0;
            for( pair p : list ){
                if( ( p.node.left!= null || p.node.right!=null ) && nextList.isEmpty()) {
                    shift = p.index;
                    if( p.node.left== null ) subOne = -1;
                }
                if( p.node.left!= null ) nextList.add( new pair( 2*(p.index - shift ) + subOne , p.node.left) );
                if( p.node.right!= null ) nextList.add( new pair( 2*(p.index - shift ) + 1 + subOne , p.node.right) );
                res = Math.max( res , p.index+1 );
            }
            list = nextList;
        }
        return res;
    }
}

