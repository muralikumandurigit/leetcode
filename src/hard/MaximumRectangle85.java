package hard;

import java.util.Stack;

public class MaximumRectangle85 {

	/*
	 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = []
Output: 0
Example 3:

Input: matrix = [["0"]]
Output: 0
Example 4:

Input: matrix = [["1"]]
Output: 1
Example 5:

Input: matrix = [["0","0"]]
Output: 0
 

Constraints:

rows == matrix.length
cols == matrix[i].length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char heights[][] = {{'1','1','0','1'},{'1','1','0','1'},{'1','1','1','1'}};
		MaximumRectangle85 obj = new MaximumRectangle85();
		System.out.println(obj.maximalRectangle(heights));

	}
	
    public int maximalRectangle(char[][] matrix) {
    	int maxArea = 0;
    	int m[][] = new int[matrix.length][];
        for (int i=0; i<matrix.length; i++) {
        	m[i] = new int[matrix[0].length];
        	for (int j=0; j<matrix[0].length; j++) {
        		m[i][j]  = i==0 ? matrix[i][j] - 48 : matrix[i][j] == '0' ? 0 : matrix[i][j]-48 + m[i-1][j];
        	}
        	maxArea = Math.max(maxArea, largestRectangleArea(m[i]));
        }
        return maxArea;
    } 
    
    private int largestRectangleArea(int[] heights) {
    	Stack<Integer> stk = new Stack<>();
    	int maxArea = 0;
    	int i;
    	for(i=0; i<heights.length; i++) {
    		if (stk.isEmpty() || heights[stk.peek()] <= heights[i]) {
    			stk.push(i);
    		}
    		else {
    			while(!stk.isEmpty() && heights[stk.peek()] > heights[i]) {
    				int top = stk.pop();
    				maxArea = Math.max(maxArea, heights[top] * (stk.isEmpty() ? i : i - stk.peek() - 1));
    			}
    			stk.push(i);
    		}
    	}
    	
		while(!stk.isEmpty()) {
			int top = stk.pop();
			maxArea = Math.max(maxArea, heights[top] * (stk.isEmpty() ? i : i - stk.peek() - 1));
		}
		
		return maxArea;
     }
}
