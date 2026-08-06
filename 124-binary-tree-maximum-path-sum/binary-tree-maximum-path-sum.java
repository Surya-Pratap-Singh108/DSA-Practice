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
     int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
      helper(root);
        
        return maxSum;
	
       
    }
    public int helper(TreeNode root){
       if(root==null){
            return 0;
            }
        int left=helper(root.left);
        
        int right=helper(root.right);
        
        int currSum=Math.max(0,left)+Math.max(0,right)+root.val;
        maxSum = Math.max(maxSum,currSum);
        return root.val+(Math.max(Math.max(0,left),Math.max(0,right)));
        
    }
}