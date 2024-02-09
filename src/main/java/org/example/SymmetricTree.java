package org.example;

public class SymmetricTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean subTreeSym( TreeNode one , TreeNode two ){
        if(one == two ){
            return true;
        }else{
            if( one == null){
                return false;
            }
            else if( two == null ){
                return false;
            }else if( one.val != two.val){
                return false;
            }else{
                return subTreeSym(one.left , two.right) && subTreeSym(one.right , two.left);
            }
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if( root == null){
            return true;
        }else if( root.left == root.right){
            return  true;
        }
        else {
            return subTreeSym( root.left , root.right);
        }
    }
}
