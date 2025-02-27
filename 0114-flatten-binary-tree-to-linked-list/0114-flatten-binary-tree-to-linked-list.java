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
    Queue<TreeNode> queue=new LinkedList<>();

    public void flatten(TreeNode root) {
        preorder(root);
        TreeNode temp=queue.poll();
        while(!queue.isEmpty()){
            TreeNode temp2=queue.poll();
            temp.right=temp2;
            temp.left=null;
            temp=temp.right;
        }
        root=temp;
    }
    public void preorder(TreeNode curr){
        if(curr==null){
            return;
        }
        queue.add(curr);
        preorder(curr.left);
        preorder(curr.right);
    }

}