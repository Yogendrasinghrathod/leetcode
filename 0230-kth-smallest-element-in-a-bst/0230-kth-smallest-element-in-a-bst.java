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
    Queue<Integer> queue=new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        for(int i=0;i<k-1;i++){
            queue.poll();
        }
        return queue.poll();
        
    }
    public void inorder(TreeNode curr){
        if(curr==null) return;
        inorder(curr.left);
        queue.offer(curr.val);
        inorder(curr.right);
    }
}