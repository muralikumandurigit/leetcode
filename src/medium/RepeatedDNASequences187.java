package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences187 {

	/*
	 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

0 <= s.length <= 105
s[i] is 'A', 'C', 'G', or 'T'.

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatedDNASequences187 obj = new RepeatedDNASequences187();
		obj.findRepeatedDnaSequences("AAAAAAAAAA").forEach(s -> System.out.println(s));

	}
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new ArrayList<String>();
    	int l = 10;
        if (s.length() <= l) {
        	return result;
        }
        else {
        	Map<String, Integer> h = new HashMap<String, Integer>();
        	for(int i=0; i<=s.length()-l; i++) {
        		String str = s.substring(i, i+l);
        		h.put(str, 1+h.getOrDefault(str, 0));
        	}
        	h.entrySet().forEach(e -> {
        		if (h.get(e.getKey()) > 1) {
        			result.add(e.getKey());
        		}
        	});
        	return result;
        }
    }
}
