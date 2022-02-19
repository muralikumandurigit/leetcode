package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedundantCollectionII685 {
/*              I N C O M P L E T E         */
	/*
	 * 
	 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
	 */
	public static void main(String[] args) {
		RedundantCollectionII685 obj = new RedundantCollectionII685();
//		int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
//		int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
//		int[][] edges = {{5,2},{5,1},{3,1},{3,4},{3,5}};
		int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
		int [] result = obj.findRedundantDirectedConnection(edges);
		System.out.println("Result => " + result[0] + "," + result[1]);
	}

	private int getParent (int k, int graph[]) {
		while (graph[k] > 0) {
			k = graph[k];
		}
		return k;
	}
	
	public int[] findRedundantDirectedConnection(int[][] edges) {
		// TODO Auto-generated method stub
		int graph[] = new int[edges.length + 1];
		boolean foundTwoParents = false;
		int s1[] = new int[2];
		int s2[] = new int[2];
				
		// Find out the nodes which has two parents
		for (int i=0; i<edges.length; i++) {
			if (graph[edges[i][1]] != 0) {
				s1[0] = graph[edges[i][1]];
				s1[1] = edges[i][1];
				
				s2[0] = edges[i][0];
				s2[1] = edges[i][1];
				foundTwoParents = true;
				// Now s1[1] is having two parents. s1[0] and s2[0]
				break;
			}
			else {
				graph[edges[i][1]] = edges[i][0];
			}
		}
		
		// Re-initialize graph.
		
		for (int i=1; i<graph.length; i++) {
			graph[i] = 0;
		}
		
		
		// Find out the circle.
		for (int i=0; i<edges.length; i++) {
			
			// If two parents, then remove s2 and see we are good to go. If yes.then s2 is culprit, else s1 is culprit
			if (foundTwoParents && s2[0] == edges[i][0] && s2[1] == edges[i][1]) {
				// Remove one node. 
				continue;
			}
			int p0 = getParent(edges[i][0], graph);
			int p1 = getParent(edges[i][1], graph);
			if (p0 == p1) {
				// We got the cycle here...
				if (foundTwoParents) {
					if (p0 == graph[s2[1]])
						return s2;
					else
						return s1;				
				}
				else {
					return edges[i];
				}
			}
			
			for (int j=1; j<graph.length; j++) {
				graph[j] = graph[j] == p1 ? p0 : graph[j];
			}
			graph[edges[i][1]] = p0;
			graph[p1] = p0;
		}
		
		// No cycle here. So just return s2;
		return s2;
	}
}
