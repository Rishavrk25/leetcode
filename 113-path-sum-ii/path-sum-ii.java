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
    boolean helper(TreeNode root,int sum, int t,List<Integer> list,List<List<Integer>> ans){
        if(root==null) return false;
        sum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==t){
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return true;
            }
            list.remove(list.size()-1);
            return false;
        }
        boolean l = helper(root.left,sum,t,list,ans);
        boolean r = helper(root.right,sum,t,list,ans);
        if(list.size()!=0) list.remove(list.size()-1);
        return l||r;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root,0,targetSum,list,ans);
        return ans;
    }
}