package org.example;

public class SearchInRotatedList {

    public int searchFromRange(int[] nums , int target , int start , int end , boolean pivot){
        if( start > end){
            return -1;
        }

        if( pivot ){
            if( nums[start] < nums[end] ){
                pivot = false;
            }
        }

        int middle = ( start + end )/2;
        if( nums[middle] == target){
            return middle;
        }else if( target > nums[middle] ){
            if( nums[middle] > nums[start] ){
                return searchFromRange( nums , target ,  middle + 1 , end , pivot );
            }else{
                int left = searchFromRange( nums , target , middle + 1 , end , pivot );
                int right = searchFromRange( nums , target , start, middle -1, pivot );
                if( left!= -1){
                    return left;
                }else{
                    return right;
                }
            }
        }else{
            if( !pivot ){
                return searchFromRange( nums , target ,  start , middle - 1 , pivot );
            }else{
                int left = searchFromRange( nums , target , middle + 1 , end , pivot );
                int right = searchFromRange( nums , target , start, middle -1, pivot );
                if( left!= -1){
                    return left;
                }else{
                    return right;
                }
            }
        }
    }

    public int search(int[] nums, int target) {
        return searchFromRange(nums , target , 0 , nums.length-1 , true );
    }
}
