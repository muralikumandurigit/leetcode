package medium;

import java.util.HashSet;
import java.util.Set;

public class RottingOranges {

	/*
	 * 
	 * 
	 * In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
	 */
	public static void main(String[] args) {
		RottingOranges obj = new RottingOranges();
		int grid[][] = {{0, 2}};
		System.out.println(obj.orangesRotting(grid));
	}

    public int orangesRotting(int[][] grid) {
    	Set<Integer> fresh = new HashSet<Integer>();
    	int rotten[] = new int[grid.length * grid[0].length];
    	int rc = 0;
    	for(int r=0; r<grid.length; r++) {
    		int columns = grid[0].length;
    		for(int c=0; c<grid[0].length; c++) {
    			int m = (r*columns)+c+1;
    			if(grid[r][c] == 1) {
    				fresh.add(m);
    			}
    			else if(grid[r][c] == 2) {
    				rotten[rc++] = m;
    			}
    		}
    	}
    	
    	int minutes=0;
    	int s=0;
    	while(!fresh.isEmpty()) {
    		int e = rc-1;
    		if(s>e) {
    			return -1;
    		}
    		while(s<=e) {
    			int top = rotten[s] - grid[0].length;
    			if(fresh.contains(top)) {
    				rotten[rc] = top;
    				fresh.remove(top);
    				rc++;
    			}
    			int bottom = rotten[s] + grid[0].length;
    			if(fresh.contains(bottom)) {
    				rotten[rc] = bottom;
    				fresh.remove(bottom);
    				rc++;
    			}
    			if (rotten[s] % grid[0].length != 1) {
        			int left = rotten[s] - 1;
        			if(fresh.contains(left)) {
        				rotten[rc] = left;
        				fresh.remove(left);
        				rc++;
        			}
    			}
    			if (rotten[s] % grid[0].length != 0) {
        			int right = rotten[s] + 1;
        			if(fresh.contains(right)) {
        				rotten[rc] = right;
        				fresh.remove(right);
        				rc++;
        			}		
    			}
    			s++;
    		}
    		minutes++;
    	}
        return minutes;
    }
}
