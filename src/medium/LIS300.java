package medium;

public class LIS300 {

	public static void main(String[] args) {
		int s[] = {0, 2};
		LIS300 obj = new LIS300();
		int maxlen = obj.lengthOfLIS(s);
		System.out.println("LIS = " + maxlen);
	}
	
    public int lengthOfLIS(int[] nums) {
    	int aryLgt = nums.length;
    	if (aryLgt == 1) {
    		return 1;
    	}
    	Integer ltary[] = new Integer[aryLgt];
    	Integer seqary[] = new Integer[aryLgt];
    	for(int i=0; i<aryLgt; i++) {
    		ltary[i] = 1;
    	}
    	
    	for(int i=0; i<aryLgt; i++) {
    		seqary[i] = i;
    	}
    	
    	for(int i=1; i<aryLgt; i++) {
    		for (int j=0; j<i; j++) {
    			if(nums[j] < nums[i]) {
    				if (ltary[i] < 1+ltary[j]) {
    					ltary[i] = 1+ltary[j];
    					seqary[i] = j;
    				}
    			}
    		}
    	}
    	
    	int maxlen = 1;
    	for(int i=0; i<aryLgt; i++) {
    		maxlen = maxlen < ltary[i] ? ltary[i] : maxlen;
    	}
    	 	
        return maxlen;
    }

}
