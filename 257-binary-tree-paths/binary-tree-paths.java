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
    void helper(TreeNode root,List<String> ans,String s){
        if(root==null) return;
        s+=root.val;
        if(root.left==null && root.right==null){
            ans.add(s);
            return;
        }
        s+="->";
        helper(root.left,ans,s);
        helper(root.right,ans,s);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,ans,"");
        return ans;
    }
}