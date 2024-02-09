package org.example;

import java.util.HashMap;

public class BinaryTreeMaximumPathSum {
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

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    public int maxPath(TreeNode root) {
        int left ; int right;
        if( root.left == null && root.right == null ) {
            if( max < root.val) max = root.val;
            return root.val;
        }
        else if( root.left!= null && root.right == null){
            left = maxPath( root.left );
            int tempMax =  root.val + left;
            if( tempMax < root.val ) tempMax = root.val;
            if( max < tempMax ) max = tempMax;
            return tempMax;
        }else if( root.left== null && root.right != null ){
            right = maxPath( root.right );
            int tempMax =  root.val + right;
            if( tempMax < root.val ) tempMax = root.val;
            if( max < tempMax ) max = tempMax;
            return tempMax;
        }else{
            left = maxPath( root.left );
            right = maxPath( root.right );
            int tempMax =  root.val + left + right;
            if( tempMax < root.val + right ) tempMax = root.val + right;
            if( tempMax < root.val + left ) tempMax = root.val + left;
            if( tempMax < root.val ) tempMax = root.val;
            if( tempMax > max ) max = tempMax;
            if( tempMax == root.val ) return  root.val;
            else if( left < right) return root.val + right;
            else return root.val + left;
        }
    }
}
