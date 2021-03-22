package easy;

public class MaximumSubarray53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
        	return 0;
        }
        
        int max = nums[0];
        int cur_sum = nums[0];
        for(int i=1; i<nums.length; i++) {
        	cur_sum = Math.max(cur_sum+nums[i], nums[i]);
        	max = Math.max(cur_sum, max);
        }
        return max;
    }
}
