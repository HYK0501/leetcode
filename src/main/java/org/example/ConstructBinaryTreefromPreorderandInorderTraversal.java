package org.example;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode build( int[] preorder, int[] inorder , int preStart  , int inStart , int inEnd ){
        TreeNode root = new TreeNode( preorder[preStart] );
        int breakPoint = inStart;
        for( int i = inStart ; i <= inEnd ; i++ ){
            if( inorder[i] == preorder[preStart] ) {
                breakPoint = i;
                break;
            }
        }
        int leftLen = breakPoint - inStart;
        int rightLen = inEnd - breakPoint;
        if( leftLen > 0 ) root.left = build(  preorder, inorder , preStart + 1 , inStart , breakPoint - 1 );
        if( rightLen > 0 ) root.right = build( preorder, inorder , preStart + leftLen + 1  , breakPoint + 1 , inEnd );
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder.length == 0 ) return null;
        else  return build( preorder , inorder , 0 , 0 , preorder.length - 1);
    }
}
