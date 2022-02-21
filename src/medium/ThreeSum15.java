package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum15 {

	/*
	 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ary[] = {-1,0,1,2,-1,-4};
		ThreeSum15 obj = new ThreeSum15();
		for (List<Integer> e : obj.threeSum(ary)) {
			e.forEach(p -> System.out.print("," + p));
			System.out.println();
		}
	}
	public List<List<Integer>> threeSum(int[] input) {
		Arrays.sort(input);
		
		Set<String> mySet = new HashSet<>();
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<input.length-2; i++) {
			int s=i+1, t=input.length-1;
			int rSum = 0-input[i];
			
			while(s<t) {
				int sum = input[s] + input[t];
				if(sum == rSum) {
					String key = input[i]+":"+input[s]+":"+input[t];
					if(!mySet.contains(key)) {
						List<Integer> list = new ArrayList<>();
						list.add(input[i]);
						list.add(input[s]);
						list.add(input[t]);
						result.add(list);
						mySet.add(key);
					}
					s++;
					t--;
				}
				else if(sum < rSum) {
					s++;
				}
				else {
					t--;
				}
			}
		}
		return result;
	}
}
