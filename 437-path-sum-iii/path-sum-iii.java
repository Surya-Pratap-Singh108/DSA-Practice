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
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map=new HashMap<>();//prefixSum, freq
        map.put(0L,1);
        helper(root,targetSum,map,0);
        return ans;
    }
    
    public void helper(TreeNode node,int targetSum,HashMap<Long,Integer> map,long currSum){
        if(node==null)return;
        
        currSum+=node.val;
        
        ans+=map.getOrDefault(currSum-targetSum,0);
        map.put(currSum,map.getOrDefault(currSum,0)+1);
        
        helper(node.left,targetSum,map,currSum);
        helper(node.right,targetSum,map,currSum);
        
        map.put(currSum,map.get(currSum)-1);
        
        if(map.get(currSum)==0)map.remove(currSum);
    }
}