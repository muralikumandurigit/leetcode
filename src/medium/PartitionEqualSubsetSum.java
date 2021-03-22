package medium;

public class PartitionEqualSubsetSum {

	/*
	 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		int nums[] = {3,3,3,4,5};
		if (obj.canPartition(nums)) {
			System.out.println("Possible");
		}
		else {
			System.out.println("Not Possible");
		}
	}
	
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i=0; i<nums.length; i++)
        	sum += nums[i];
        if (sum %2 != 0)
        	return false;
        int targetSum = sum/2;
        int matrix[][] = new int[nums.length][];
        for (int i=0; i<nums.length; i++) {
        	matrix[i] = new int[targetSum+1];
        	matrix[i][0] = 1;
        }
        
        for (int i=0; i<nums.length; i++) {
        	for(int j=1; j<=targetSum; j++) {
        		if (i==0) {
        			matrix[i][j] = j==nums[i] ? 1 : 0;
        		}
        		else {
        			if (matrix[i-1][j] == 1) {
        				matrix[i][j] = 1;
        			}
        			else {
        				int remainingSum = j - nums[i];
        				matrix[i][j] = remainingSum >=0 ? matrix[i-1][remainingSum] : 0;
        			}
        		}
        	}
        	if (matrix[i][targetSum] == 1) {
        		return true;
        	}
        }
        return false;
    }
}
