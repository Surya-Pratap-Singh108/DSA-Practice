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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode curr, TreeNode p, TreeNode q) {

        if (curr == null) {
            return null;
        }

        if (curr == p || curr == q) {
            return curr;
        }

        TreeNode left = helper(curr.left, p, q);
        TreeNode right = helper(curr.right, p, q);

        if (left != null && right != null) {
            return curr;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}