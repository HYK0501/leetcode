package org.example;

public class isValidBST {

    public boolean Valid(TreeNode root ,long min ,long max) {
        if( root == null ) return true;
        else if( (long) root.val < min || (long) root.val > max ) return false;
        else return Valid(root.left , min , root.val ) && Valid(root.right , root.val , max );
    }
    public boolean isValidBST(TreeNode root) {
        return Valid( root , Long.MIN_VALUE , Long.MAX_VALUE);
    }
}

