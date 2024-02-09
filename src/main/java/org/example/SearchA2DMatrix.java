package org.example;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int up = matrix.length*matrix[0].length - 1;
        int singleRowLen = matrix[0].length;
        while( low <= up){
            int mid = ( low + up )/2;
            if( matrix[mid/singleRowLen][mid%singleRowLen] == target) return  true;
            else if( matrix[mid/singleRowLen][mid%singleRowLen] > target ) low = mid+1;
            else up = mid - 1;
        }
        return false;
    }
}
