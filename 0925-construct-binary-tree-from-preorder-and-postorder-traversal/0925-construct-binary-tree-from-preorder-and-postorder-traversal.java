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
    int []pre_arr;
    int []post_arr;
    Map<Integer,Integer> map=new HashMap<>();
    int index=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        pre_arr=preorder;
        post_arr=postorder;
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return dfs(preorder.length);
    }

    private TreeNode dfs(int preIndex){
        if(index>=pre_arr.length){
            return null;
        }
        int currVal=pre_arr[index];
        int currIndex=map.get(currVal);
        if(preIndex<currIndex){
            return null;
        }
        index++;
        TreeNode root=new TreeNode(currVal);
        root.left=dfs(currIndex);
        root.right=dfs(currIndex);
        return root;

    }
}