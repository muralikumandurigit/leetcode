package hard;

import java.util.Stack;

public class LargestRectangleInHistogram84 {

	/*
	 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int heights[] = {2,1,5,6,2,3};
//		int heights[] = {2,4};
//		int heights[] = {2,1,2};
		LargestRectangleInHistogram84 obj = new LargestRectangleInHistogram84();
		System.out.println(obj.largestRectangleArea(heights));
	}
	
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if (heights.length == 0) {
        	return 0;
        }
        if (heights.length ==1) {
        	return heights[0];
        }
        
        Stack<Integer> stk = new Stack<>();
        
        for (int i=0; i<heights.length; i++) {
        	if (i==0) {
        		stk.push(i);
        	}
        	else if (heights[stk.peek()] <= heights[i]) {
        		stk.push(i);
        	}
        	else {
        		while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
        			int h = stk.pop();
        			int p = stk.isEmpty() ? -1 : stk.peek();
        			int area = heights[h] * (i-p-1);
        			maxArea = Math.max(maxArea, area);
        		}
        		stk.push(i);
        	}
        }
        while(!stk.isEmpty()) {
        	int h = stk.pop();
        	int p = stk.isEmpty() ? -1 : stk.peek();
        	int area = heights[h] * (heights.length - p-1);
        	maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
 