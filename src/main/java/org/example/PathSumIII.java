package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PathSumIII {

    long sum = 0;

    HashMap<Long , Integer> accAppearMap = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if( root == null ) return 0;
        accAppearMap.merge(sum, 1, Integer::sum );
        int times = 0;
        sum = sum + root.val;
        System.out.println( sum );
        if( accAppearMap.keySet().contains( sum - targetSum ) ) times = times + accAppearMap.get( sum - targetSum );


        if( root.left != null ) times = times + pathSum( root.left , targetSum );
        if( root.right!=null ) times = times + pathSum( root.right , targetSum );

        sum = sum - root.val;
        if( accAppearMap.get(sum) == 1) accAppearMap.remove(sum);
        else accAppearMap.put( sum , accAppearMap.get(sum) -1 );

        return times;
    }
}