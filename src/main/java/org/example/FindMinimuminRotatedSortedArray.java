package org.example;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0; int end = nums.length -1;
        while( low < end && nums[low] > nums[end]){
            int mid = ( low + end )/2;
            if( nums[mid] > nums[end] ) low = mid+1;
            else end = mid;//is mid because mid+1 maybe ignore the smallest
        }
        return nums[low];
    }
}
