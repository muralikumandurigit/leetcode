package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FallingSquares699 {

	/*
	 * 
	 * On an infinite number line (x-axis), we drop given squares in the order they are given.

The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point being positions[i][0] and sidelength positions[i][1].

The square is dropped with the bottom edge parallel to the number line, and from a higher height than all currently landed squares. We wait for each square to stick before dropping the next.

The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length surface they touch (either the number line or another square). Squares dropped adjacent to each other will not stick together prematurely.

 
Return a list ans of heights. Each height ans[i] represents the current highest height of any square we have dropped, after dropping squares represented by positions[0], positions[1], ..., positions[i].

Example 1:

Input: [[1, 2], [2, 3], [6, 1]]
Output: [2, 5, 5]
Explanation:
After the first drop of positions[0] = [1, 2]: _aa _aa ------- The maximum height of any square is 2.

After the second drop of positions[1] = [2, 3]: __aaa __aaa __aaa _aa__ _aa__ -------------- The maximum height of any square is 5. The larger square stays on top of the smaller square despite where its center of gravity is, because squares are infinitely sticky on their bottom edge.

After the third drop of positions[1] = [6, 1]: __aaa __aaa __aaa _aa _aa___a -------------- The maximum height of any square is still 5. Thus, we return an answer of [2, 5, 5].

 

 
Example 2:

Input: [[100, 100], [200, 100]]
Output: [100, 100]
Explanation: Adjacent squares don't get stuck prematurely - only their bottom edge can stick to surfaces.
 

Note:

1 <= positions.length <= 1000.
1 <= positions[i][0] <= 10^8.
1 <= positions[i][1] <= 10^6.

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int positions[][] = {{1, 2}, {2, 3}, {6, 1}};
//		int positions[][] = {{100, 100}, {200, 100}};
//		int positions[][] = {};
//		int positions[][] = {{9, 7}, {1, 9}, {3, 1}};
//		int positions[][] = {{2, 1}, {2, 9}, {1, 8}};
//		int positions[][] = {{50,47},{95,48},{88,77},{84,3}, {53,87}, {98,79}, {88,28},{13,22},{53,73},{85,55}};
//		int positions[][] = {{50,47},{95,48},{88,77},{84,3}, {53,87}};
//		int positions[][] = {{1,47},{46,48},{39,77},{35,3}, {4,87}};
		FallingSquares699 obj = new FallingSquares699();
		List<Integer> result = obj.fallingSquares(positions);
		System.out.println(result);
	}

    public List<Integer> fallingSquares(int[][] positions) {
        
    	int heights[] = new int[positions.length];
    	int maxCurHeights[] = new int[positions.length];
    	int maxCurHeight=0;
    	for(int i=0; i<positions.length; i++) {
    		int start = positions[i][0];
    		int height = positions[i][1];
    		int end = start + height;
    		heights[i] += height;
    		for(int j=i+1; j<positions.length; j++) {
    			int start2 = positions[j][0];
    			int height2 = positions[j][1];
    			int end2 = start2+height2;
    			if (start2 >= end || end2 <= start) {
    				continue;
    			}
    			heights[j] = Math.max(heights[i], heights[j]);	
    		}
    		maxCurHeight = Math.max(maxCurHeight, heights[i]);
    		maxCurHeights[i] = Math.max(maxCurHeight, maxCurHeights[i]);
    	}
    	return Arrays.stream(maxCurHeights).boxed().collect(Collectors.toList());
    }
    
    public List<Integer> fallingSquares1(int[][] positions) {
        
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
