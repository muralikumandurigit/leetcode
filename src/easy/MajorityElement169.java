package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        for (int n : nums) {
        	int count = 1 + m.getOrDefault(n, 0);
        	if (count > nums.length/2) {
        		return n;
        	}
        	m.put(n, count);
        }
        return 1;
    }
}
