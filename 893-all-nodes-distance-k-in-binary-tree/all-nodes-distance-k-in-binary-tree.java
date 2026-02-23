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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> set = new HashSet<>(); // visited
        set.add(target);
        int level=0;
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            if(level==k){
                while(!q.isEmpty()) ans.add(q.remove().val);
                return ans;
            }
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(node.left!=null && !set.contains(node.left)){
                    q.add(node.left);
                    set.add(node.left);
                }
                if(node.right!=null && !set.contains(node.right)){
                    q.add(node.right);
                    set.add(node.right);
                }
                TreeNode parent = map.get(node);
                if(parent!=null && !set.contains(parent)){
                    q.add(map.get(node));
                    set.add(map.get(node));
                }
            }
            level++;
        }
        return ans;
    }
}