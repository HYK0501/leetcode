package org.example;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left = -1;int right = -1;
        int lo = 0;
        int hi = nums.length;
        while( lo < hi ){
            int mid = lo + ( hi- lo)/2;
            if( nums[mid] < target ) lo = mid + 1;
            else{
                if( nums[mid] == target ) left = mid;
                hi = mid;
            }
        }
        lo = 0;
        hi = nums.length;
        while( lo < hi ){
            int mid = lo + (hi - lo)/2;
            if( nums[mid] > target ) hi = mid;
            else{
                if( nums[mid] == target ) right = mid;
                lo = mid+1;
            }
        }
        return new int[]{ left , right};
    }
}
