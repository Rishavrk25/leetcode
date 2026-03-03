/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node==null){
                sb.append("n ");
                continue;
            }
            sb.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length()==0) return null;
        String arr[] = data.trim().split(" ");
        if(arr[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode node = q.remove();
            if(!arr[i].equals("n")){
                node.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.left);
            }
            i++;
            if(!arr[i].equals("n")){
                node.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));