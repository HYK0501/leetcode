package org.example;

import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTree {
    Map<TreeNode , Integer> map;
    public boolean balanced( TreeNode root ){
        boolean right = true;
        int leftHeight = 0;int rightHeight = 0;
        if( root.left != null ){
            if ( !balanced( root.left )) return false;
            leftHeight = map.get( root.left );
        }
        if( root.right != null){
            if( !balanced( root.right )) return false;
            rightHeight = map.get( root.right );
        }
        if( Math.abs( leftHeight - rightHeight) < 1){
            map.put( root , Math.max( leftHeight , rightHeight ) + 1);
            return true;
        }else return false;
    }
    public boolean isBalanced(TreeNode root) {
        map = new HashMap<>();
        return balanced( root );
    }
}
