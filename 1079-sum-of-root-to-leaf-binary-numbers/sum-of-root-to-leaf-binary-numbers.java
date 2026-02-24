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
    int stringToInt(String s){
        int ans=0;
        int base = 1;
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            ans+= (ch-'0') * base;
            base*=2;
        }
        return ans;
    }
    int helper(TreeNode root,String s){
        if(root==null) return 0;
        s+=root.val;
        if(root.left==null && root.right==null){
            return stringToInt(s);
        }
        int l=helper(root.left, s);
        int r=helper(root.right,s);
        return l+r;
    }
    public int sumRootToLeaf(TreeNode root) {
        return helper(root,"");
    }
}