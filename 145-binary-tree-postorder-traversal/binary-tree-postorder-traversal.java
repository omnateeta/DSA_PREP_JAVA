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
    public void traverse(List <Integer> res, TreeNode node)
    {
        if(node == null) return;
        traverse(res,node.left);
        traverse(res,node.right);
        res.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        traverse(res, root);
        return res;
    }
}