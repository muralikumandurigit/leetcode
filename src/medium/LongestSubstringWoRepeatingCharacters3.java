package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
Accepted
2,987,643
Submissions
9,099,768
 */
public class LongestSubstringWoRepeatingCharacters3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWoRepeatingCharacters3 obj = new LongestSubstringWoRepeatingCharacters3();
		System.out.println(obj.lengthOfLongestSubstring("1231"));
	}

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int st = 0;
        int maxLen = 0;
        int len = 0;
        int i;

        for(i=0; i<s.length(); i++) {
        	int p = m.getOrDefault(s.charAt(i), -1);
        	if (p<0 || p<st) {
        		m.put(s.charAt(i), i);
        	}
        	else {
        		len = i-st;
        		maxLen = Math.max(maxLen, len);
        		st = 1 + m.get(s.charAt(i));
        		m.put(s.charAt(i), i);
        	}
        }

        len = i-st;
		maxLen = Math.max(maxLen, len);
		return maxLen;
    }
    
}
