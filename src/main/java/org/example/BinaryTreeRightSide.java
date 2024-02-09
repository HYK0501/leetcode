package org.example;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSide {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<TreeNode> level = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if( root != null){
            res.add( root.val );
            level.add( root );
        }
        while( !level.isEmpty() ){
            TreeNode rightest = null;
            ArrayList<TreeNode> nextLevel = new ArrayList<>();
            for( TreeNode node : level ){
                if( node.left != null){
                    nextLevel.add( node.left );
                    rightest = node.left;
                }
                if( node.right != null){
                    nextLevel.add( node.right );
                    rightest = node.right;
                }
            }
            level = nextLevel;
            if( rightest != null){
                res.add( rightest.val );
            }
        }
        return res;
    }
}
