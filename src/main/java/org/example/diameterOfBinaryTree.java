package org.example;

import java.util.HashMap;
import java.util.Map;

public class diameterOfBinaryTree {
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

  public Map<TreeNode , Integer> map = new HashMap<>();

  public int recordHeight( Map<TreeNode , Integer> map , TreeNode root){
      if( root == null){
          return 0;
      }
      else if( root.left == null && root.right == null){
          map.put( root , 1);
          return 1;
      }else{
          int left = recordHeight( map , root.left);
          int right = recordHeight( map , root.right);
          int res = 1 + Math.max( left , right);
          map.put( root , res);
          return res;
      }
  }

  public int getByMap( TreeNode node){
      if(node == null){
          return 0;
      }else{
          return map.get(node);
      }
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if( root == null){
        return 0;
    }
    recordHeight(map , root);
    int max = 0;
    for(TreeNode node : map.keySet()){
        int temp = getByMap( node.left ) + getByMap( node.right ) ;
        if( temp > max){
            max = temp;
        }
    }
    return max;
  }
}
