package medium;

public class SearchA2DMatrix240 {

	/*
	 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{1,   4,  7, 11, 15},
				          {2,   5,  8, 12, 19},
				          {3,   6,  9, 16, 22},
				          {10, 13, 14, 17, 24},
				          {18, 21, 23, 26, 30}};
		SearchA2DMatrix240 obj = new SearchA2DMatrix240();
		for(int target=0; target<31; target++) {
			System.out.println(target + " => " + obj.searchMatrix(matrix, target));
		}
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0) {
    		return false;
    	}
    	
        int startRow = 0;
        int endRow = matrix.length-1;
        int startColumn = 0;
        int endColumn = matrix[0].length-1;
        
        while(startRow <= endRow && startColumn <= endColumn) {
            if(target == matrix[startRow][endColumn]) {
            	return true;
            }
            else if (target > matrix[startRow][endColumn]) {
            	startRow++;
            }
            else {
            	endColumn--;
            } 	
        }
        return false;
    }
}
