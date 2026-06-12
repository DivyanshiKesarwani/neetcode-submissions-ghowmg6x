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
    public int kthSmallest(TreeNode root, int k) {
        //inorder
        ArrayList<Integer> arr=inorder(root);
        return arr.get(k-1);
    }
    public void in(ArrayList<Integer>arr,TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        in(arr,root.left);
        arr.add(root.val);
        in(arr,root.right);
    }
    public ArrayList<Integer> inorder(TreeNode root)
    {
        // Code here
        ArrayList<Integer>res=new ArrayList<>();
        in(res,root);
        return res;
    }
}
