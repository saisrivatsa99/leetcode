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
class Solution {
    private int maxSum;
    private int helper(TreeNode root){
        if(root== null) return 0;
        int leftsum = Math.max(0, helper(root.left));
        int rightsum = Math.max(0, helper(root.right));
        maxSum = Math.max(maxSum, leftsum + rightsum + root.val);

        return Math.max(leftsum, rightsum) + root.val;

    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum; 
    }
}