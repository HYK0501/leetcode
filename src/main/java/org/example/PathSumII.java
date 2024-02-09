package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

    int sum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(pathSumMain(root , targetSum));
        return res;
    }
    public List<LinkedList<Integer>> pathSumMain(TreeNode root, int targetSum) {
        List<LinkedList<Integer>> res = new ArrayList<>();
        if( root == null){
            return res;
        }
        sum = sum + root.val;
        if( root.left == null && root.right == null ){
            if( sum == targetSum){
                LinkedList<Integer> temp = new LinkedList<>();
                temp.addFirst( root.val );
                res.add( temp );
            }
        }else{
            List<LinkedList<Integer>> temps = new ArrayList<>();
            if( root.left != null ){
                temps = pathSumMain( root.left , targetSum);
            }
            if( root.right != null){
                List<LinkedList<Integer>> rightTemps = pathSumMain( root.right , targetSum);
                if( !rightTemps.isEmpty() ) temps.addAll( rightTemps );
            }
            if( !temps.isEmpty() ){
                for( LinkedList<Integer> temp : temps ){
                    temp.addFirst( root.val );
                    res.add( temp );
                }
            }
        }
        sum = sum - root.val;
        return res;
    }
}
