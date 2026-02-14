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
    void helper(TreeNode root,int sum, int t,List<Integer> list,List<List<Integer>> ans){
        if(root==null) return;
        sum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==t){
                ans.add(new ArrayList<>(list));
            }
        }
        else{
            helper(root.left,sum,t,list,ans);
            helper(root.right,sum,t,list,ans);
        }
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root,0,targetSum,list,ans);
        return ans;
    }
}