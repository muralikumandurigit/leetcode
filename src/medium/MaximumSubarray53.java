package medium;

public class MaximumSubarray53 {

	/*
	 * 
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
  
A subarray is a contiguous part of an array.

 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
        	return 0;
        }
        
        int max = nums[0];
        int cur_sum = nums[0];
        for(int i=1; i<nums.length; i++) {
        	cur_sum = Math.max(cur_sum+nums[i], nums[i]);
        	max = Math.max(cur_sum, max);
        }
        return max;
    }
}
