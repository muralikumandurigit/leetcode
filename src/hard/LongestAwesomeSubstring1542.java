package hard;

import java.util.HashMap;
import java.util.Map;

public class LongestAwesomeSubstring1542 {

	/*
	 * Given a string s. An awesome substring is a non-empty substring of s such that we can make any number of swaps in order to make it palindrome.

Return the length of the maximum length awesome substring of s.

 

Example 1:

Input: s = "3242415"
Output: 5
Explanation: "24241" is the longest awesome substring, we can form the palindrome "24142" with some swaps.
Example 2:

Input: s = "12345678"
Output: 1
Example 3:

Input: s = "213123"
Output: 6
Explanation: "213123" is the longest awesome substring, we can form the palindrome "231132" with some swaps.
Example 4:

Input: s = "00"
Output: 2
 

Constraints:

1 <= s.length <= 10^5
s consists only of digits.
	 */
    public int longestAwesome(String s) {
    	Map<Integer, int[]> maskMap = new HashMap<>();
    	int mask = 0;
    	int a[] = {-1,-1};
    	int maxLen = 0;
    	maskMap.put(mask, a);
    	for (int i=0; i<s.length(); i++) {
    		int p = s.charAt(i) - 48;
    		mask = mask ^ (1 << p);
    		// Check for even
    		if (maskMap.containsKey(mask)) {
    			a = maskMap.get(mask);
    			a[1] = i;
    			maxLen = Math.max(maxLen, a[1] - a[0]);
    			maskMap.put(mask, a);
    		}
    		else {
    			int b[] = {i,-1};
    			maskMap.put(mask, b);
    		}
    		
    		// Check for odd
    		for (int j=0; j<10; j++) {
    			int m = mask ^ (1 << j);
        		if (maskMap.containsKey(m)) {
        			a = maskMap.get(m);
        			maxLen = Math.max(maxLen, i - a[0]);
        		}
    		}
    	}
    	return maxLen;
    }
    
	public static void main(String[] args) {
		LongestAwesomeSubstring1542 obj = new LongestAwesomeSubstring1542();
		System.out.println(obj.longestAwesome(""));

	}
	
}
