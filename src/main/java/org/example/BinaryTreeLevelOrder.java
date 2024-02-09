package org.example;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder {

    public void addInLevel( TreeNode root , int level , List<List<Integer>> list){
        //number of level is next level of root
        if( root.right != null || root.left != null) {
            if (list.size() - 1 < level + 1) {
                List<Integer> vals = new ArrayList<>();
                list.add(vals);
            }
            List<Integer> levelVal = list.get(level + 1);
            if (root.left != null) {
                levelVal.add(root.left.val);
                addInLevel(root.left, level + 1 , list);
            }
            if (root.right != null) {
                levelVal.add(root.right.val);
                addInLevel(root.right, level + 1 , list);
            }
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root != null){
            List<Integer> vals = new ArrayList<>();
            vals.add( root.val );
            addInLevel(root , 1 , res);
        }
        return res;
    }
}
