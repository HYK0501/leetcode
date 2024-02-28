package org.example;

public class SearchInRotatedList {

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        //last always 2 or 1
        //when 2 -> mid may is low so hi = mid - 1 will < low
        while( lo < hi ){
            int mid = ( lo + hi )/2;
            if( nums[mid] < nums[hi] ) hi = mid;
            else lo = mid + 1;
        }
        int pivot = lo;
        int start ; int end;
        if( pivot > 0 ){
            if( target > nums[0] ){
                start = 0;
                end = pivot - 1;
            }else{
                start = pivot;
                end = nums.length - 1;
            }
        }else{
            start = 0;
            end = nums.length - 1;
        }
        while( start <= end ){
            int mid = ( start + end )/2;
            if( target < nums[mid] ) end = mid - 1;
            else if( target == nums[mid] ) return mid;
            else start = mid + 1;
        }
        return -1;
    }
}
