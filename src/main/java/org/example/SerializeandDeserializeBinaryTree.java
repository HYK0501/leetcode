package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class SerializeandDeserializeBinaryTree { // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<TreeNode> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if( root != null ){
            temp.add( root );
            sb.append( root.val );
        }
        while( !temp.isEmpty() ){
            ArrayList<TreeNode> nextTemp = new ArrayList<>();
            for( TreeNode node : temp ){
                sb.append("/");
                if( node.left!=null ) {
                    sb.append( node.left.val );
                    nextTemp.add( node.left );
                }
                else sb.append( "N" );
                sb.append("/");
                if( node.right !=null ){
                    sb.append( node.right.val );
                    nextTemp.add( node.right );
                }
                else sb.append( "N" );
            }
            temp = nextTemp;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if( data.equals("") ) return null;
        else{
            String[] nodeDatas = data.split("/");
            int nodeTotal = 3;
            int start = 1;
            TreeNode root = new TreeNode( Integer.parseInt( nodeDatas[0] ) );
            ArrayList<TreeNode> temp = new ArrayList<>();
            temp.add( root );
            //System.out.println(data);
            while( nodeTotal <= nodeDatas.length  ){
                int parentIndex = 0;
                int builded = 0;
                ArrayList<TreeNode> nextTemp = new ArrayList<>();
                for(int i = start ; i < nodeTotal ; i++){
                    if( !nodeDatas[i].equals("N") ) {
                        TreeNode node = new TreeNode( Integer.parseInt( nodeDatas[i]  ) );
                        if( i%2==1 ) temp.get(parentIndex).left = node;
                        else temp.get(parentIndex).right= node;
                        nextTemp.add(node);
                        builded++;
                    }
                    if( i%2 == 0 ) parentIndex++;
                }
                temp = nextTemp;
                start = nodeTotal;
                if(builded!=0)nodeTotal = nodeTotal + builded*2;
                else break;
            }
            return root;
        }
    }
}
