package org.example;

public class SubTreeOfOtherTree {
    public boolean checkSame( TreeNode root, TreeNode subRoot ){
        if( root == null){
            return ( root == subRoot);
        }else{
            if( root.val == subRoot.val ){
                return ( checkSame( root.left , subRoot.left ) && checkSame(root.right, subRoot.right));
            }else{
                return false;
            }
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if( root == null){
            return ( root == subRoot);
        }else if( root.val == subRoot.val ){
            return checkSame( root , subRoot);
        }else{
            return isSubtree( root.right , subRoot) || isSubtree( root.left , subRoot);
        }
    }
}
