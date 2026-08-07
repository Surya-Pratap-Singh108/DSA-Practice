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
    
    class Pair{
        TreeNode node;
        int pos;
        Pair(TreeNode node,int pos){
            this.node=node;
            this.pos=pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        int ans=Integer.MIN_VALUE;
        if(root==null)return 0;
        Queue<Pair> q=new ArrayDeque<>();
        
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            boolean  left=true;
            int leftIndex=0;
            int rightIndex=0;
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                if(left){//i==0
                    leftIndex=curr.pos;
                    left=false;
                    
                }
                rightIndex=curr.pos;//i==size-1;
                
                
                if(curr.node.left!=null){
                    q.offer(new Pair(curr.node.left,2*curr.pos+1));
                }
                if(curr.node.right!=null){
                    q.offer(new Pair(curr.node.right,2*curr.pos+2));
                }
            }
            ans=Math.max(ans,rightIndex-leftIndex+1);
            
        }
        
        return ans;
	}
	
}
// class Pair {
//     TreeNode node;
//     long index;  // ✅ changed from int → long
//     Pair(TreeNode node, long index) {
//         this.node = node;
//         this.index = index;
//     }
// }

// class Solution {
//     public int widthOfBinaryTree(TreeNode root) {
//         if (root == null) return 0;

//         int ans = 0;
//         Queue<Pair> q = new LinkedList<>();
//         q.offer(new Pair(root, 0));  // 0 is treated as long automatically

//         while (!q.isEmpty()) {
//             int size = q.size();
//             long first = 0, last = 0;  // ✅ long for safe subtraction

//             for (int i = 0; i < size; i++) {
//                 Pair curr = q.poll();
//                 long idx = curr.index;  // ✅ use long here

//                 if (i == 0) first = idx;
//                 if (i == size - 1) last = idx;

//                 // ✅ computations done using long
//                 if (curr.node.left != null)
//                     q.offer(new Pair(curr.node.left, 2 * idx + 1));

//                 if (curr.node.right != null)
//                     q.offer(new Pair(curr.node.right, 2 * idx + 2));
//             }

//             ans = Math.max(ans, (int)(last - first + 1));  // ✅ cast back to int for result
//         }

//         return ans;
//     }
// }

