package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllNodesDistanceKinBinaryTree {
    ArrayList<Integer> res = new ArrayList<>();
    LinkedList<TreeNode> rootToTargetHistory = new LinkedList<>();
    public void find( TreeNode root , TreeNode target){
        if(root != null ) rootToTargetHistory.add(root);
        else return;
        if( !root.equals(target) ) {
            find( root.left , target);
            if( !rootToTargetHistory.getLast().equals(target) ) {
                find(root.right, target);
                if( !rootToTargetHistory.getLast().equals(target) ) rootToTargetHistory.removeLast();
            }
        }
    }
    public void down(TreeNode root , int len , int k){
        if( len == k ){
            res.add( root.val );
        }else if( len < k){
            if( root.left != null) down( root.left , len+1 , k );
            if( root.right != null ) down( root.right , len+1 , k );
        }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root , target);
        for( TreeNode node : rootToTargetHistory ) System.out.println( node.val );
        while ( !rootToTargetHistory.isEmpty() ){
            TreeNode head = rootToTargetHistory.removeFirst(); TreeNode headChild = null;
            int headToTarget = rootToTargetHistory.size();
            if( headToTarget == k ) res.add(head.val);
            else if( headToTarget < k ){
                if( !rootToTargetHistory.isEmpty() ) {
                    headChild = rootToTargetHistory.peekFirst();
                    if( head.left != null ) if( !head.left.equals( headChild ) ) down( root.left , headToTarget+1 , k );
                    if( head.right != null ) if( !head.right.equals( headChild ) ) down( root.right , headToTarget+1 , k );
                }else{
                    if( head.left != null ) down( root.left , headToTarget+1 , k );
                    if( head.right != null ) down( root.right , headToTarget+1 , k );
                }
            }
        }
        return res;
    }
}
