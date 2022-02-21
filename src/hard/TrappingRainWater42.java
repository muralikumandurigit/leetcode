package hard;

public class TrappingRainWater42 {

	/*
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
	 */
	public static void main(String[] args) {
		int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater42 obj = new TrappingRainWater42();
        System.out.println(obj.trap(height));
	}

    public int trap(int[] height) {
        if (height.length < 3)
        	return 0;
        
        int totalVol = 0;
        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];
        int mLeft=0, mRight=0;
        for(int i=0; i<height.length; i++) {
        	if (i==0) {
        		maxLeft[i] = 0;
        	}
        	else {
        		mLeft = Math.max(mLeft, height[i-1]);
        		maxLeft[i] = mLeft;
        	}
        }
        for(int i=height.length-1; i>=0; i--) {
        	if (i==height.length-1) {
        		maxRight[i] = 0;
        	}
        	else {
        		mRight = Math.max(mRight, height[i+1]);
        		maxRight[i] = mRight;
        	}
        }
        
        for(int i=1; i<height.length-1; i++) {
        	int waterLevel = Math.min(maxLeft[i], maxRight[i]);
        	if (waterLevel > height[i]) {
            	int curVol = (waterLevel - height[i]);
            	totalVol += curVol;	
        	}
        }
        return totalVol;
    }
    
}
