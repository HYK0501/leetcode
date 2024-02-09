package org.example;

public class KthSmallestElementinaBST {
    int res = -1;
    int order = -1;
    public int kthSmallest(TreeNode root, int k) {

        if( root.left == null ){
            order ++;
            if( order == k ){
                res = root.val;
            }else if( root.right != null){
                res = kthSmallest( root.right , k);
            }
        }else{
            res = kthSmallest( root.left , k);//left
            if( res == -1){
                order ++; //,middle
                if( order == k ){
                    res = root.val;
                }else if( root.right != null){
                    res = kthSmallest( root.right , k);
                }
            }
        }
        return res;
    }
}
