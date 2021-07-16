class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(res, path, nums, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, int begin){
        res.add(new ArrayList<>(path));
        for(int i = begin; i < nums.length; i++){
            if(i > begin && nums[i] == nums[i - 1]){
                continue;
            }
            path.addLast(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.removeLast();
        }
    }
}
//idea: backtracking + prune(dfs)只需要判断当前数字和上一个数字是否相同，相同的话跳过即可。当然，要把数字首先进行排序。
//时间复杂度和空间复杂度不确定，主要取决于nums
// 时间复杂度：排序复杂度为 O(nlogn)，爆搜复杂度为 (2^n)，每个方案通过深拷贝存入答案，复杂度为 O(n)。整体复杂度为 (n * 2^n)
// 空间复杂度：总共有 2^n个方案，每个方案最多占用 O(n) 空间，整体复杂度为 (n * 2^n)
