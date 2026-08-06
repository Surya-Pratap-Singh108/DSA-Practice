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
    boolean isSum=false;
    public boolean hasPathSum(TreeNode root,int targetSum){
        if(root==null)return false;
        helper(root,targetSum);
	
        return isSum;
    }
    public void helper(TreeNode root,int targetSum){
       if(root!=null&&root.left==null&&root.right==null){
            if(targetSum-root.val==0)isSum=true;
            return;
        }
        if(root==null)return;
        
        helper(root.left,targetSum-root.val);
        helper(root.right,targetSum-root.val);
          
        
    }
}