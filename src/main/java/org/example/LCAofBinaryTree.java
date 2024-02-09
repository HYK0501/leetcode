package org.example;

import java.util.HashMap;
import java.util.Map;

public class LCAofBinaryTree {
    public boolean markAncestor(Map<TreeNode, Boolean> map , TreeNode node , TreeNode target){
        boolean left = false;
        boolean right = false;
        if( node.left != null ){
            if(node.left.equals(target) ){
                map.put( node , true );
                return true;
            }else{
                left = markAncestor(map , node.left , target );
            }
        }
        if( node.right != null ){
            if(node.right.equals(target) ){
                map.put( node , true );
                return true;
            }else{
                right = markAncestor(map , node.right , target );
            }
        }
        map.put( node , left || right );
        return left || right;
    }

    public TreeNode getLCA(Map<TreeNode, Boolean> pMap , Map<TreeNode, Boolean> qMap , TreeNode root){
        Boolean qbool = qMap.get( root );
        Boolean pbool = pMap.get( root );
        if( qbool == null || pbool == null){
            return null;
        }else{
            if( qbool && pbool){
                TreeNode left = null;
                TreeNode right = null;
                if( root.left != null ){
                    left = getLCA( pMap , qMap , root.left);
                }
                if( root.right != null ){
                    right = getLCA( pMap , qMap , root.right);
                }
                if( right==null && left==null ){
                    return root;
                }else{
                    if( left == null){
                        return right;
                    }else{
                        return left;
                    }
                }
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, Boolean> pAncestor = new HashMap<>();
        HashMap<TreeNode , Boolean> qAncestor = new HashMap<>();
        markAncestor( pAncestor , root , p);
        markAncestor( qAncestor , root , q);
        return getLCA( pAncestor , qAncestor , root );
    }
}
