package org.example;

import java.util.HashMap;
import java.util.Map;

public class LCAofBinaryTree {
    TreeNode res = null;
    public boolean[] find( TreeNode root, TreeNode p, TreeNode q ){
        boolean pRight = false;
        boolean qRight = false;
        if( root.equals(p) ) pRight = true;
        if( root.equals(q) ) qRight = true;
        boolean[] left = new boolean[]{ false , false };
        boolean[] right = new boolean[]{ false , false };
        boolean[] rootPQ = new boolean[2];
        if( root.left != null ) left = find( root.left , p , q );
        if( root.right != null ) right = find( root.right , p , q );
        rootPQ[0] = pRight || left[0] || right[0];
        rootPQ[1] = qRight || left[1] || right[1];
        if( rootPQ[0] && rootPQ[1] && res == null ) res = root;
        return rootPQ;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find( root , p , q );
        return res;
    }
}
