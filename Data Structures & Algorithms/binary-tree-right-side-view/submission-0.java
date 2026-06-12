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
    
     public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer>res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);//1
        while(!q.isEmpty())
        {
            int size=q.size();//2
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();//2
                if(temp.left!=null)
                {
                    q.add(temp.left);//4
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);//5
                }
                if(i==size-1)
                {res.add(temp.val);}
            }
            
        }
        return res;
    }
}
