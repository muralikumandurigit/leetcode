package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWConcatenationOfAllWords30 {

	/*
	 * 
	 * You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
The output order does not matter. Returning [9,0] is fine too.
Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
We return an empty array.
Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.
 
Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "barfoothefoobarman";
//		String words[] = {"foo","bar"};
//		String s = "wordgoodgoodgoodbestword";
//		String words[] = {"word","good","best","word"};
//		String s = "barfoofoobarthefoobarman";
//		String words[] = {"bar","foo","the"};
		String s = "wordgoodgoodgoodbestword";
		String words[] = {"word","good","best","good"};
		SubstringWConcatenationOfAllWords30 obj = new SubstringWConcatenationOfAllWords30();
		System.out.println(obj.findSubstring(s, words));
	}

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int subLgt = words.length*words[0].length();
        
        if (s.length() < subLgt) {
        	return result;
        }
        
        Map<String, Integer> hMap = new HashMap<>();
        Map<String, Integer> tMap;
        int wLength = words[0].length();
        for(int i=0; i<words.length; i++) {
        	hMap.put(words[i], 1+hMap.getOrDefault(words[i], 0));
        }
        
        for (int i=0; i<=s.length()-subLgt; i++) {
        	tMap = new HashMap<>();
        	tMap.putAll(hMap);
        	for (int j=0; j<words.length; j++) {
        		String str = s.substring(i+(j*wLength), i+(wLength*(j+1)));
        		Integer v = tMap.remove(str);
        		if (v == null) {
        			break;
        		}
        		else if (v > 1){
        			tMap.put(str, v-1);
        		}
        	}
        	
        	if (tMap.isEmpty()) {
        		result.add(i);
        	}
        }
        return result;
    }
    
}
