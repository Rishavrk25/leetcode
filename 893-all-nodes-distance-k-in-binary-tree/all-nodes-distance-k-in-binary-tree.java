/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void helper(TreeNode root,Map<TreeNode,TreeNode> map){
        if(root==null) return;
        if(root.left!=null){
            map.put(root.left,root);
            helper(root.left,map);
        }
        if(root.right!=null){
            map.put(root.right,root);
            helper(root.right,map);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>(); // node,parent
        helper(root,map);
        // bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int level=0;
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode node = q.remove();
                if(level==k) ans.add(node.val);
                if(node.left!=null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = map.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            level++;
        }
        return ans;
    }
}