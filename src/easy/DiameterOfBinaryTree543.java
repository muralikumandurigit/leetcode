package easy;

import java.util.HashMap;
import java.util.Map;

public class DiameterOfBinaryTree543 {
	/*
	 * Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
	 */
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiameterOfBinaryTree543 obj = new DiameterOfBinaryTree543();
		TreeNode o1 = obj.new TreeNode(-1, null, null); // Leaf
		TreeNode o2 = obj.new TreeNode(0, null, o1);
		TreeNode o3 = obj.new TreeNode(-4, null, null); // Leaf
		TreeNode o4 = obj.new TreeNode(6, o3, null);
		TreeNode o5 = obj.new TreeNode(6, o2, o4);
		o1 = obj.new TreeNode(9, o5, null);
		o2 = obj.new TreeNode(5, null, null); // Leaf
		o3 = obj.new TreeNode(-6, o2, null); 
		o2 = obj.new TreeNode(-2, null, null); // Leaf
		o4 = obj.new TreeNode(9, o2, null);
		o5 = obj.new TreeNode(-6, o4, null);
		o2 = obj.new TreeNode(-7, o3, o5);
		o3 = obj.new TreeNode(-9, o1, o2);
		o1 = obj.new TreeNode(-4, null, null); // Leaf
		o2 = obj.new TreeNode(-3, o1, null);
		o1 = obj.new TreeNode(-3, o3, o2);
		o2 = obj.new TreeNode(-2, null, null); // Leaf
		TreeNode root = obj.new TreeNode(4, o2, o1);
		System.out.println(obj.diameterOfBinaryTree(root));
	}
	
	int maxDiameter = 0;

	private int heightOfBinaryTree(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        else if (root.left == null && root.right == null) {
        	return 0;
        }
        else if (root.left == null) {
        	int h = 1 + heightOfBinaryTree(root.right);
        	maxDiameter = Math.max(maxDiameter, h);
        	return h;
        }
        else if (root.right == null) {
        	int h = 1 + heightOfBinaryTree(root.left);
        	maxDiameter = Math.max(maxDiameter, h);
        	return h;
        }
        else {
        	int lh = 1 + heightOfBinaryTree(root.left);
        	int rh = 1 + heightOfBinaryTree(root.right);
        	int h =  Math.max(lh, rh);
        	maxDiameter = Math.max(maxDiameter, lh + rh);
        	return h;
        }
	}
	
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        else if (root.left == null && root.right == null) {
        	return 0;
        }
        else if (root.left == null) {
            return 1 + heightOfBinaryTree(root.right);
        }
        else if (root.right == null) {
            return 1 + heightOfBinaryTree(root.left);
        }
        else {
        	int lh = 1 + heightOfBinaryTree(root.left);
        	int rh = 1 + heightOfBinaryTree(root.right);
        	return Math.max(maxDiameter, lh+rh);
        }
    }
}
