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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
	}
	public boolean helper(TreeNode p,TreeNode q){
	    if(p==null&&q==null){
            return true;
        }
        else if(p==null||q==null||p.val!=q.val){
            return false;
        }
        return helper(p.left,q.right)&&helper(p.right,q.left);
	}
}
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//    Queue<TreeNode> queue=new LinkedList<>();
    //     queue.add(root.left);
    //     queue.add(root.right);
    //     while (!queue.isEmpty()){
    //         TreeNode left=queue.poll();
    //         TreeNode right=queue.poll();
    //         if(left==null&&right==null){
    //             continue;
    //         }
    //         if(left==null||right==null){
    //             return false;
    //         }
    //         if(left.val!=right.val){
    //             return false;
    //         }
    //         queue.offer(left.left);
    //         queue.offer(right.right);
    //         queue.offer(left.right);
    //         queue.offer(right.left);
    //     }
    //     return true;
    // }
    //more optimal
//     public boolean isSymmetric(TreeNode root) {
//     if (root == null) return true;
//     return isMirror(root.left, root.right);
// }

// private boolean isMirror(TreeNode left, TreeNode right) {
//     if (left == null && right == null) return true;
//     if (left == null || right == null) return false;
//     if (left.val != right.val) return false;

//     return isMirror(left.left, right.right) && 
//            isMirror(left.right, right.left);
// }

// }