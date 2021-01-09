package easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementIn2NArray961 {

	/*
	 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5
 

Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int repeatedNTimes(int[] A) {
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<A.length; i++) {
        	if (s.contains(A[i])) {
        		return A[i];
        	}
        	else {
        		s.add(A[i]);
        	}
        }
        return -1;
    }
}
