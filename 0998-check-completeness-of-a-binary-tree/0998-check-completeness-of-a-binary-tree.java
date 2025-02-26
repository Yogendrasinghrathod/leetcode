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
    
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean foundNull=false;
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp==null){
                foundNull=true;
            }
            else{
                if (foundNull==true){
                    return false;
                }
                queue.add(temp.left);
                queue.add(temp.right);

            }
            
        }
        return foundNull;
    }
   
}