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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new LinkedList<>();
        if(root==null)return ans;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> currL=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode currN=q.poll();
                currL.add(currN.val);
                if(currN.left!=null)q.offer(currN.left);
                if(currN.right!=null)q.offer(currN.right);
            }
            ans.add(currL);
            // ans.add(newLinkedList(currL));
        }
        return ans;
    }
}