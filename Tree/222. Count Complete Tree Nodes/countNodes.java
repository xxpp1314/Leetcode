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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int h = 0;
        while(right != null){
            left = left.left;
            right = right.right;
            h++;
        }
        if(left == null){
            return (int)Math.pow(2, h) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
//idea: recursion
//time:O(h ^ 2)
//space:O(1)
