package hard;

public class ContainerWithMostWater11 {

	/*
	 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int height[] = {1,8,6,2,5,4,8,3,7};
		ContainerWithMostWater11 obj = new ContainerWithMostWater11();
		System.out.println(obj.maxArea(height));
	}
	
    public int maxArea1(int[] height) {
    	int maxVol = 0;
        for (int i=0; i<height.length-1; i++) {
        	for(int j=i+1; j<height.length; j++) {
        		int h = Math.min(height[i], height[j]);
        		int vol = h*(j-i);
        		maxVol = Math.max(maxVol, vol);
        	}
        }
        return maxVol;
    }
    
    public int maxArea(int[] height) {
    	int maxVol = 0;
        int i=0, j=height.length-1;
        while(i<j) {
        	if (height[i]<height[j]) {
        		maxVol = Math.max(maxVol, height[i]*(j-i));
        		i++;
        	}
        	else {
        		maxVol = Math.max(maxVol, height[j]*(j-i));
        		j--;      		
        	}
        }
        return maxVol;
    }
}