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
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        indexMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
    }
    
    private TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int postorder_left, int postorder_right){
        if(inorder_left > inorder_right){
            return null;
        }
        int postorder_root = postorder_right;
        int inorder_root = indexMap.get(postorder[postorder_root]);
        TreeNode root = new TreeNode(postorder[postorder_root]);
        int left_size_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1, postorder_left, postorder_left + left_size_subtree - 1);
        root.right = myBuildTree(inorder, postorder, inorder_left + left_size_subtree + 1, inorder_right, postorder_left + left_size_subtree, postorder_right - 1);
        return root;
    }
}
//idea:dfs + hashmap
//time complexity: O(n), n is the nodes number
//space complexity: O(n), 除去返回的答案需要的 O(n)空间之外，我们还需要使用 O(n)的空间存储哈希映射，以及 O(h)（其中h  是树的高度）的空间表示递归时栈空间。这里 h < n，所以总空间复杂度为 O(n)。
