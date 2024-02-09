package org.example;

public class isValidBST {

    public boolean Valid(TreeNode root ,int min ,int max) {
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right == null) {
            if (min <= root.left.val && root.left.val < root.val) {
                return Valid(root.left, min, root.val - 1 );
            }else {
                return false;
            }
        } else if (root.left == null && root.right != null) {
            if (root.right.val > root.val && root.right.val <= max) {
                return Valid(root.right, root.val +  1 , max);
            }else {
                return false;
            }
        } else {
            if (root.left.val < root.val && root.left.val >= min && root.right.val > root.val && root.right.val <= max) {
                return (Valid(root.left, min, root.val -1 ) && Valid(root.right, root.val +1, max));
            } else {
                return false;
            }
        }
    }


    public boolean isValidBST(TreeNode root) {

        if( root.left == null && root.right == null){
            return true;
        }else if( root.left != null && root.right == null){
            if( root.left.val < root.val){
                return Valid( root.left , Integer.MIN_VALUE , root.val-1 );
            }else{
                return false;
            }
        }else if( root.left == null && root.right != null){
            if( root.right.val > root.val){
                return Valid( root.right , root.val+1 , Integer.MAX_VALUE);
            }else{
                return false;
            }
        }else{
            if( root.left.val < root.val && root.right.val > root.val){
                return ( Valid( root.left , Integer.MIN_VALUE , root.val-1 ) && Valid( root.right , root.val+1 , Integer.MAX_VALUE) );
            }
            else{
                return false;
            }
        }
    }
}

