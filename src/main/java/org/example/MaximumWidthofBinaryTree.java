package org.example;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Map<Long , TreeNode> indexMap = new HashMap<>();
        long max = 1;long start;long end;
        if(root!=null)indexMap.put( 0L,root );
        while( true  ){
            start = Long.MAX_VALUE;end =Long.MIN_VALUE;
            Map<Long , TreeNode> nextIndexMap = new HashMap<>();
            for( Long key : indexMap.keySet() ){
                TreeNode node = indexMap.get( key );
                if( node.left != null ){
                    if( 2*key < start ) start = 2*key;
                    if( end < 2*key) end = 2*key;
                    nextIndexMap.put( 2*key , node.left);
                }
                if( node.right != null ){
                    if( 2*key+1 < start ) start = 2*key+1;
                    if( end < 2*key+1) end = 2*key+1;
                    nextIndexMap.put( 2*key + 1, node.right);
                }
            }
            indexMap = nextIndexMap;
            if( indexMap.isEmpty() ) break;
            if( max < end - start +1) max = end - start +1;
        }
        return (int)max;
    }
}

