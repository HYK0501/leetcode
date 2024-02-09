package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean leftToRight = true;//current is  left to right
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if( root != null ) currentLevel.add( root );
        while( !currentLevel.isEmpty() ){
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            LinkedList<Integer> temp = new LinkedList<>();
            while( !currentLevel.isEmpty()  ){
                TreeNode node = currentLevel.removeLast();
                temp.addLast( node.val );
                if( leftToRight ){
                    if( node.left != null ) nextLevel.add( node.left );
                    if( node.right != null ) nextLevel.add( node.right );
                }
                else{
                    if( node.right != null ) nextLevel.add( node.right );
                    if( node.left != null ) nextLevel.add( node.left );
                }
            }
            res.add(temp);
            currentLevel = nextLevel;
            leftToRight = !leftToRight;
        }
        return res;
    }
}
