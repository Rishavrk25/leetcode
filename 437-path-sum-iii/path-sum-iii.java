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
    int helper(TreeNode root,long sum,int t){
        if(root==null) return 0;
        sum+=root.val;
        int count=0;
        if(sum==t) count++;
        count+= helper(root.left,sum,t)+helper(root.right,sum,t);
        return count;
    }
    public int pathSum(TreeNode root, int t) {
        if(root==null) return 0;
        return helper(root,0,t) + pathSum(root.left,t) + pathSum(root.right,t);
    }
}