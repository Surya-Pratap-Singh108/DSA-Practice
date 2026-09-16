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
    private int preorder_index=0;
    public TreeNode buildTree(int[] preorder,int[] inorder){
        HashMap<Integer,Integer> inHm=new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inHm.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1,inHm);
     }
    public TreeNode helper(int[] preorder,int l,int r,HashMap<Integer,Integer> inHm){
       if(l>r){
           return null;
       }
       TreeNode node=new TreeNode(preorder[preorder_index]);
       int node_index=inHm.get(preorder[preorder_index]);
       preorder_index++;

        node.left=helper(preorder,l,node_index-1,inHm);
        node.right=helper(preorder,node_index+1,r,inHm);
        return node;

    }
}
