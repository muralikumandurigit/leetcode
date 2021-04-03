package medium;

import java.util.HashSet;
import java.util.Set;

public class RedundantConnection684 {

	/*
	 * In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int edges[][] = {{3,4},{1,2},{2,4},{3,5},{2,5}};
        RedundantConnection684 obj = new RedundantConnection684();
        int res[] = obj.findRedundantConnection(edges);
        System.out.println(res[0] + "," + res[1]);
	}

	private int getParent(int k, int graph[]) {
		
		while (graph[k] > 0) {
			k = graph[k];
		}
		return k;
	}
	
	
    public int[] findRedundantConnection(int[][] edges) {
        int graph[] = new int[edges.length + 1];
        // Initially the complete graph has the 0 that means all are the root nodes.
        
        // Take each edge in the order of the given edges and join the trees.
        for (int i=0; i<edges.length; i++) {
        	int p0 = getParent(edges[i][0], graph);
        	int p1 = getParent(edges[i][1], graph);
        	if (p0 == p1) {
        		return edges[i];
        	}
        	
        	if (p0 < p1) {
        		// make p0 as root
        		for (int j=1; j<=edges.length; j++) {
        			graph[j] = graph[j] == p1 ? p0 : graph[j];
        		}
        		graph[edges[i][1]] = p0;
        		graph[p1] = p0;
        	}
        	else {
        		// make p1 as root
        		for (int j=1; j<=edges.length; j++) {
        			graph[j] = graph[j] == p0 ? p1 : graph[j];
        		}
        		graph[edges[i][0]] = p1;
        		graph[p0] = p1;
        	}
        }
        return new int[2];
    }
    
}
