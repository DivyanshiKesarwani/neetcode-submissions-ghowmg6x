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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String>res=new ArrayList<>();
        if(root==null)return "";
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(temp==null)
                {
                    res.add("N");
                    continue;
                }
                else
                {
                    q.add(temp.left);
                    q.add(temp.right);
                }
                   
                res.add(String.valueOf(temp.val));
            }
            
        }   
        
        String ans = String.join(",", res); 
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       // String data = "1,2,3,N,N,4,5";
       if (data == null || data.length() == 0) {
        return null;
    }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) 
        {
            TreeNode curr = q.poll();
            if (!arr[i].equals("N")) {
            curr.left = new TreeNode(Integer.parseInt(arr[i]));
            q.add(curr.left);
        }
        i++;
        if (i < arr.length && !arr[i].equals("N")) {
            curr.right = new TreeNode(Integer.parseInt(arr[i]));
            q.add(curr.right);
        }
        i++;
        }
        return root;
    }
}
