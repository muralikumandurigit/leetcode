package medium;

public class DecodeWays91 {

	/*
	 * A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

  

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with 0.
The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
Hence, there are no valid ways to decode this since all digits need to be mapped.
Example 4:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays91 obj = new DecodeWays91();
		System.out.println(obj.numDecodings("27"));
	}
/*
    public int numDecodings(String s) {
    	int c[]= new int[s.length()];
        for (int i=0; i<s.length(); i++) {
        	if (s.charAt(i) != '0') {
        		if (i==0) {
        			c[i] = 1;
        		}
        		else {
        			int k = Integer.parseInt(s.substring(i-1, i+1));
        			if (k >=11 && k <= 26) {
        				c[i] = i == 1 ? 1 + c[i-1] : c[i-1] + c[i-2];
        			}
        			else {
        				c[i] = c[i-1];
        			}
        		}
        	}
        	else {
        		if (i==0) {
        			return 0;
        		}
        		else {
        			if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
        				c[i] = i == 1 ? 1 : c[i-2];
        			}
        			else {
        				return 0;
        			}
        		}
        	}
        }
        return c[s.length()-1];
    }
    */
    
    public int numDecodings(String s) {
    	if (s.length() == 0 || s.charAt(0) == '0')
    		return 0;
    	int prevPrev = 1, prev=1;
    	for (int i=1; i<s.length(); i++) {
    		int d = s.charAt(i) - '0';
    		int dd = (s.charAt(i-1) - '0')*10 + d;
        	int count=0;
    		if (d > 0) {
    			count = prev;
    		}
    		if (dd >= 10 && dd <= 26) {
    			count += prevPrev;
    		}
    		prevPrev = prev;
    		prev = count;
    	}
    	return prev;
    }
}
