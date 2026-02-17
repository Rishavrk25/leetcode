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
class Triplet{
    TreeNode node;
    int idx;
    int level;
    Triplet(TreeNode node,int idx,int level){
        this.node=node;
        this.idx=idx;
        this.level=level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<int[]>> map = new TreeMap<>(); // idx, list of (val,level)
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root,0,0));
        while(!q.isEmpty()){
            Triplet t = q.remove();
            TreeNode node =t.node;
            int idx=t.idx;
            int level=t.level;
            if(!map.containsKey(idx)) map.put(idx,new ArrayList<>());
            map.get(idx).add(new int[]{node.val,level});
            if(node.left!=null) q.add(new Triplet(node.left,idx-1,level+1));
            if(node.right!=null) q.add(new Triplet(node.right,idx+1,level+1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int idx : map.keySet()){
            List<int[]> list = map.get(idx);
            Collections.sort(list,(a,b)->{
                if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
                return Integer.compare(a[1],b[1]);
            });
            List<Integer> temp = new ArrayList<>();
            for(int p[] : list) temp.add(p[0]);
            ans.add(temp);
        }
        return ans;
    }
}