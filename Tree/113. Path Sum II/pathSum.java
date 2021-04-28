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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, targetSum, path, res);
        return res;
    }
    
    private void dfs(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> res){
        if(root == null){
            return;
        }
        if(root.val == targetSum && root.left == null && root.right == null){
            path.addLast(root.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        path.addLast(root.val);
        dfs(root.left, targetSum - root.val, path, res);
        dfs(root.right, targetSum - root.val, path, res);
        path.removeLast();
    }
}
//idea: dfs + backtracking
//time complexity:O(N)
//space complexity: O(L), L is max length of path
