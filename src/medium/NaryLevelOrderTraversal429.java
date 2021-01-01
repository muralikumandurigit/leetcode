package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryLevelOrderTraversal429 {

	/*
	 * 
	 * 429. N-ary Tree Level Order Traversal
Medium

779

54

Add to List

Share
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 

Constraints:

The height of the n-ary tree is less than or equal to 1000
The total number of nodes is between [0, 104]

	 */
	
	
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root != null) {
    		Queue <Node> q = new LinkedList<Node>();
    		result.add(List.of(root.val));
    		q.add(root);
    		while(!q.isEmpty()) {
    			List<Integer> il = new ArrayList<>();
    			int qsize = q.size();
    			for(int i=0; i<qsize; i++) {
    				List<Node> children = q.poll().children;
    				if (children != null) {
    					for(Node n : children) {
    						q.add(n);
    						il.add(n.val);
    					}
    				}
    			}
    			if (il.size() > 0)
    				result.add(il);
    		}
    	}
        return result;
    } 
}
