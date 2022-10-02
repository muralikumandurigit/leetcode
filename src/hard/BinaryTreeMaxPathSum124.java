package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
 */
public class BinaryTreeMaxPathSum124 {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	int max = Integer.MIN_VALUE;
	Map<TreeNode, Integer> pathSumMap = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    private int pathSum1(TreeNode root) {
    	int m;
    	if (pathSumMap.containsKey(root)) {
    		m = pathSumMap.get(root);
    	}
    	else if (root.left == null && root.right == null) {
    		m = root.val;
        	pathSumMap.put(root, m);
        	max = Math.max(max,  m);
        }
    	else if (root.left == null) {
    		m = Math.max(root.val, root.val + pathSum1(root.right));
    		pathSumMap.put(root, m);
    		max = Math.max(max,  m);
    	}
    	else if (root.right == null) {
    		m = Math.max(root.val, root.val + pathSum1(root.left));
    		pathSumMap.put(root, m);
    		max = Math.max(max,  m);
    	}
    	else {
    		m = Math.max(root.val, root.val + Math.max(pathSum1(root.right), pathSum1(root.left)));
    		pathSumMap.put(root, m);
    		max = Math.max(max, root.val + pathSum1(root.left) + pathSum1(root.right));
    		max = Math.max(max, m);
    	}
    	return m;
    }
    
    public int maxPathSum1(TreeNode root) {
    	pathSum1(root);
    	return max;
    }
    
    public int maxPathSum(TreeNode root) {
        return pathSum(root);
    }
    
    public int pathSum(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	if (root.left == null && root.right == null) {
    		return root.val;
    	}
    	else if (root.left == null) {
    		return Math.max(root.val, root.val + pathSum(root.right));
    	}
    	else if (root.right == null) {
    		return Math.max(root.val, root.val + pathSum(root.left));
    	}
    	else {
    		int t = Math.max(pathSum(root.left), pathSum(root.right));
    		return Math.max(root.val, t);
    	}
    }
}
