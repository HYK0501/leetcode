package org.example;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSide {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> childs = new ArrayList<>();
        if( root == null ) return res;
        childs.add( root );
        while( !childs.isEmpty() ){
            res.add( childs.get( childs.size()-1 ).val );
            ArrayList<TreeNode> nextChilds = new ArrayList<>();
            for( TreeNode node : childs ){
                if( node.left != null ) nextChilds.add(node.left);
                if( node.right != null ) nextChilds.add(node.right);
            }
            childs = nextChilds;
        }
        return res;
    }
}
