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


    public boolean isValidBST(TreeNode node) {
        return validateBST(node,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    boolean validateBST(TreeNode curr,long min,long max){
        if(curr==null){
            return true;
        }
        if(curr.val<=min || curr.val>=max){
            return false;
        }
        boolean leftSubtree=validateBST(curr.left,min,curr.val);
        boolean rightSubtree=validateBST(curr.right,curr.val,max);

        return leftSubtree && rightSubtree;
    }

}