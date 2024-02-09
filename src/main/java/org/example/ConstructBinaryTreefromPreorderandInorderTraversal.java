package org.example;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode build( int[] preorder, int[] inorder
            , int preRootLoaction , int nodeNumber ,int inStart , int inEnd ){
        if( inStart < inEnd){
            return null;
        }
        TreeNode treeNode = new TreeNode( preorder[preRootLoaction] );
        TreeNode left = null;
        TreeNode right = null;

        if( nodeNumber > 1){
            int rootLocationInoder = 1;
            for(int i = inStart ; i <= inEnd ; i++){
                if( inorder[i] == preorder[preRootLoaction] ){
                    rootLocationInoder = i;
                    break;
                }
            }
            int leftLen = rootLocationInoder - inStart;
            int rightLen = inEnd - rootLocationInoder;
            left = build( preorder , inorder , preRootLoaction + 1
                    , leftLen , inStart , rootLocationInoder - 1 );
            right = build( preorder , inorder , preRootLoaction + leftLen + 1
                    , rightLen , rootLocationInoder  + 1 , inEnd );
        }
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build( preorder , inorder , 0 , preorder.length , 0 , preorder.length - 1 );
    }
}
