package org.example;

import org.example.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ConvertSortedArrayToHeightBlanceTree {
    //TreeNode res = null;
    public TreeNode build( int[] nums , int begin , int end , TreeNode node){

        if( begin > end){
            return null;
        }else{
            int half = ( begin + end )/2;
            if( node == null){
                node = new TreeNode( nums[half] );
            }
            node.right = build( nums , half+1 , end , node.right );
            node.left = build( nums , begin , half-1 , node.right );
        }
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build( nums , 0 , nums.length -1 , null);
    }
}
