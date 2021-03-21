package medium;

public class MaximumProductSubarray152 {

	/*
	 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-1,0,-1};
		MaximumProductSubarray152 obj = new MaximumProductSubarray152();
		System.out.println(obj.maxProduct(nums));
	}

    public int maxProduct(int[] nums) {
    	int maxprod = nums[0];
        for (int i=0; i<nums.length; i++) {
    		int curprod = 1;
        	for (int j=i; j<nums.length; j++) {
        		curprod = i==j ? nums[j] : curprod * nums[j];
        		maxprod = Math.max(maxprod, curprod);
        	}
        }
        return maxprod;
    }
}
