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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        temp(ans, root, targetSum, list, 0);

        return ans;
    }

    public void temp(List<List<Integer>> ans,
                     TreeNode root,
                     int targetSum,
                     List<Integer> list,
                     int currSum) {

        if(root == null){
            return;
        }

        currSum += root.val;
        list.add(root.val);

        if(root.left == null && root.right == null){

            if(currSum == targetSum){
                ans.add(new ArrayList<>(list));
            }

            list.remove(list.size()-1);  
            return;
        }

        temp(ans, root.left, targetSum, list, currSum);
        temp(ans, root.right, targetSum, list, currSum);

        list.remove(list.size()-1);   
    }
}