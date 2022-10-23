package medium;

import java.util.*;

class TreeNode {
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
public class HouseRobberIII337 {
/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */




    public static void main(String args[]) {
        HouseRobberIII337 obj = new HouseRobberIII337();
        //[3,2,3,null,3,null,1]
 /*       TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, null, t3);
        TreeNode t1 = new TreeNode(1);
        t3 = new TreeNode(3, null, t1);
        TreeNode root = new TreeNode(3, t2, t3);

  */
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1, t2, null);
        TreeNode root = new TreeNode(3, null, t1);
        System.out.println(obj.rob(root));
    }
    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        else if (root.left == null ) {
            return Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
        }
        else if (root.right == null ) {
            return Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
        }
        else {
            return Math.max(root.val + rob(root.right.left) + rob(root.right.right) + rob(root.left.left) + rob(root.left.right), rob(root.right) + rob(root.left));
        }
    }

    public int rob(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        Queue<TreeNode> traverseQ = new LinkedList<>();
        traverseQ.offer(root);

        // Push all the elements to stack in level order from root.
        while(!traverseQ.isEmpty()) {
            TreeNode t = traverseQ.poll();
            if (t.left != null) {
                traverseQ.offer(t.left);
            }
            if (t.right != null) {
                traverseQ.offer(t.right);
            }
            stk.push(t);
        }

        Map<TreeNode, Integer> map = new HashMap<>();

        while(!stk.isEmpty()) {
            TreeNode t = stk.pop();
            if (t.left == null && t.right == null) {
                map.put(t, t.val);
            }
            else if (t.left == null ) {
                // t.right is available
                map.put(t, Math.max(t.val + (t.right.left != null ? map.get(t.right.left) : 0) +
                                            (t.right.right != null ? map.get(t.right.right) : 0),
                                    map.get(t.right)));
            }
            else if (t.right == null ) {
                map.put(t, Math.max(t.val + (t.left.left != null ? map.get(t.left.left) : 0) +
                                            (t.left.right != null ? map.get(t.left.right) : 0),
                                    map.get(t.left)));
            }
            else {
                map.put(t, Math.max(t.val + (t.left.left != null ? map.get(t.left.left) : 0) +
                                            (t.left.right != null ? map.get(t.left.right) : 0) +
                                            (t.right.left != null ? map.get(t.right.left) : 0) +
                                            (t.right.right != null ? map.get(t.right.right) : 0),
                        map.get(t.left) + map.get(t.right)));
            }
        }
        return map.get(root);
    }
}
