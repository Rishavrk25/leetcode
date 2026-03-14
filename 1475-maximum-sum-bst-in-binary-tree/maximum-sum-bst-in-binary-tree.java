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
class Info{
    int min;
    int max;
    int sum;
    Info(int min,int max,int sum){
        this.min=min;
        this.max=max;
        this.sum=sum;
    }
}
class Solution {
    int maxSum=0;
    Info helper(TreeNode root){
        if(root==null) return new Info(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        Info left = helper(root.left);
        Info right = helper(root.right);
        // valid bst
        if(root.val > left.max && root.val < right.min){
            int currMin = Math.min(root.val,left.min);
            int currMax = Math.max(root.val,right.max);
            int currSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum,currSum);
            return new Info(currMin,currMax,currSum);
        }
        else{
            return new Info(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.sum,right.sum));
        }
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
}