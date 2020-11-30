package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LargestNumber179 {

	/*
	 * 
	 * Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {0, 0};
		LargestNumber179 obj = new LargestNumber179();
		System.out.println(obj.largestNumber(nums));
	}
	
	String largestNumber(int nums[]) {
		if (nums.length == 0) {
			return "";
		}
		String strAry[] = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(strAry, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s1.compareTo(s2) > 0 ? -1:1;
			}
			
		});
		String ans = Arrays.stream(strAry).collect(Collectors.joining(""));
		int i;
		for (i=0; i < ans.length() && ans.charAt(i) == '0'; i++);
		if (i==ans.length()) {
			return "0";
		}
		return ans.substring(i);
	}
}
