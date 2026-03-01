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
    TreeNode s = null;
    void helper(Map<TreeNode,TreeNode> map, TreeNode root,int t){
        if(root==null) return;
        if(root.val==t) s=root;
        if(root.left!=null){
            map.put(root.left,root);
            helper(map,root.left,t);
        }
        if(root.right!=null){
            map.put(root.right,root);
            helper(map,root.right,t);
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> map = new HashMap<>(); // node,parent
        helper(map,root,start);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(s);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(s);
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.remove();
                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent=map.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            level++;
        }
        return level-1;
    }
}