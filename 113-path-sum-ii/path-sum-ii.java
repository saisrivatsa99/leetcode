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
    List<List<Integer>> ans = new ArrayList();
    List<Integer> arr = new ArrayList();
        
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return ans;
        targetSum -= root.val;
        arr.add(root.val);
        if(root.left== null && root.right == null){
            if(targetSum==0) ans.add(new ArrayList<>(arr));
        }
        else{
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        arr.remove(arr.size()-1);
        return ans;
    }
}