/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        helper(root,p,q);
        
        return ans;
	}
	
	public int helper(TreeNode curr, TreeNode p, TreeNode q){
	    
	    if(curr==null){
	        return 0;
	    }
	    if(ans!=null){//optional
	        return 0;//anything
	    }
	    
	    int left=helper(curr.left,p,q);
	    int right=helper(curr.right,p,q);
	    
	    
	    int self=0;
	    if(curr==p||curr==q){
	        self=1;
	    }
	    
	    int total=left+right+self;
	    if(total==2&&ans==null){
	        ans=curr;
	    }
	    return total;
	    
	}
}