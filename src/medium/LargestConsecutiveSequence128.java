package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LargestConsecutiveSequence128 {

	/*
	 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Follow up: Could you implement the O(n) solution? 

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109

	 */
	public static void main(String[] args) {
		LargestConsecutiveSequence128 obj = new LargestConsecutiveSequence128();
		int n[] = null;
		System.out.println(obj.longestConsecutive(n));

	}

	
    public int longestConsecutive(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int l = 0;
    	Set<Integer> mySet = Arrays.stream(nums).boxed()
    	                           .collect(Collectors.toSet());
        for(int i=0; i<nums.length; i++) {
        	if (!mySet.contains(nums[i] - 1)) {
        		int c = 1;
        		int n= nums[i]+ 1;
        		while (mySet.contains(n++)) {
        			c++;
        		}
        		l = c > l ? c: l;
        	}
        }
        return l;
    }
    
/*    public int longestConsecutive(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int l = 0;
    	Set<Integer> mySet = new HashSet<Integer>();
    	for(int i=0; i<nums.length; i++) {
    		mySet.add(nums[i]);
    	}
        for(int i=0; i<nums.length; i++) {
        	if (!mySet.contains(nums[i] - 1)) {
        		int c = 1;
        		int n= nums[i]+ 1;
        		while (mySet.contains(n++)) {
        			c++;
        		}
        		l = c > l ? c: l;
        	}
        }
        return l;
    } */
}
