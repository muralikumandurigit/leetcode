package easy;

public class InvertBinaryTree226 {

	/*
	 * 
	 * Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
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

	}
	
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
    	
        if (root.left == null && root.right == null) {
        	return root;
        }
        else if (root.left == null) {
        	root.left = root.right;
        	root.right = null;
        	invertTree(root.left);
        }
        else if (root.right == null) {
        	root.right = root.left;
        	root.left = null;
        	invertTree(root.right);
        }
        else {
        	TreeNode tmp = root.right;
        	root.right = root.left;
        	root.left = tmp;
        	invertTree(root.left);
        	invertTree(root.right);
        }
        return root;
    }
}
