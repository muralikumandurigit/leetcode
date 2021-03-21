package hard;

public class Candy135 {

	/*
	 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
1 <= ratings[i] <= 2 * 104
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy135 obj = new Candy135();
		int ratings[] = {1,3,4,5,2};
		System.out.println(obj.candy(ratings));
	}

    public int candy(int[] ratings) {
    	int candies[] = new int[ratings.length];
    	
    	// Initialize all with 1
        for (int i=0; i<ratings.length; i++) {
        	candies[i] = 1;
        }
        
        // Increasing once...
        for (int i=1; i<ratings.length; i++) {
        	if(ratings[i] > ratings[i-1]) {
        		candies[i] = Math.max(candies[i], 1 + candies[i-1]);
        	}
        }
        
        // Decreasing once...
        for (int i=ratings.length-2; i>=0; i--) {
        	if(ratings[i] > ratings[i+1]) {
        		candies[i] = Math.max(candies[i], 1 + candies[i+1]);
        	}
        }
        
        // Calculate sum...
        int s = 0;
        for (int i=0; i<ratings.length; i++) {
        	s += candies[i];
        }
        return s;
    }
}
