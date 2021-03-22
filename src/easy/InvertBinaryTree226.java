package easy;

public class InvertBinaryTree226 {

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
