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
    List<Integer> res = new ArrayList<>();
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? res : Arrays.asList(-1);
    }
    
    private Boolean dfs(TreeNode node, int[] voyage){
        if(node == null){
            return true;
        }
        if(node.val != voyage[i++]){
            return false;
        }
        if(node.left != null && node.left.val != voyage[i]){
            res.add(node.val);
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        }
        return dfs(node.left, voyage) && dfs(node.right, voyage);
    } 
}
//idea: dfs
//Time O(N)
//Space O(N)
//Global integer i indicates next index in voyage v.
// If current node == null, it's fine, we return true
// If current node.val != v[i], doesn't match wanted value, return false
// If left child exist but don't have wanted value, flip it with right child.
