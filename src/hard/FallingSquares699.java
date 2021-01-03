package hard;

import java.util.ArrayList;
import java.util.List;

public class FallingSquares699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> fallingSquares(int[][] positions) {
        
    	int heights[] = new int[positions.length];
    	List<Integer> ans = new ArrayList<>();
    	for(int i=0; i<positions.length; i++) {
    		int start = positions[i][0];
    		int height = positions[i][1];
    		int end = start + height;
    		heights[i] += height;
    		for(int j=i+1; j<positions.length; j++) {
    			int start2 = positions[j][0];
    			int height2 = positions[j][1];
    			int end2 = start2 + height2;
    			
    			if (start2 >= end || end2 <= start) {
    				continue;
    			}
    			heights[j] = Math.max(heights[i], heights[j]);
    		}
    	}
    	
    	int cur = -1;
    	for (int i=0; i<positions.length; i++) {
    		cur = Math.max(cur, heights[i]);
    		ans.add(cur);
    	}
    	return ans;
    }
    
}
