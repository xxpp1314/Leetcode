class Solution {
    public boolean canPartitionKSubsets(int[] A, int k) {
        int sum = 0;
        int maxNum = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            maxNum = Math.max(maxNum, A[i]);
        }
        if(sum % k != 0 || maxNum > sum / k){
            return false;
        }
        boolean[] used = new boolean[A.length];
        return backtrack(A, k, sum / k, 0, 0, used);
    }
    
    private boolean backtrack(int[] A, int k, int target, int cur, int begin, boolean[] used){
        if(k == 0){
            return true;
        }
        if(cur == target){
            return backtrack(A, k - 1, target, 0, 0, used);
        }
        for(int i = begin; i < A.length; i++){
            if(!used[i] && cur + A[i] <= target){
                used[i] = true;
                if(backtrack(A, k, target, cur + A[i], i + 1, used)){//cur已经加了A[i],因此begin从i + 1开始
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
//idea: backtracking
//This is a Backtracking, not DFS algorithm. DFS has linear complexity and this one has exponential one.
//思路：注意到这个时候的递归函数backtracking是有返回值的，为什么有的递归函数没有返回值，有的需要返回值呢？
// 因为本题只要找到一个结果就行了，需要在找到这个结果的时候就立刻返回，也就是本题的
// if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
// 如果需要找到所有的结果（所有的划分），那么这个时候的backtracking( )不需要返回值，这个时候添加一个参数ans（一个容器），用来装全部的结果。
//time:O((k*2^n)). I think the time complexity is O(K * 2^N). At least it's the upper bound. This approach could be seen to have 2 recursive layers. Inner layer is to find a subset sum that equals to a target, which all takes 2^n in the worst case. The outer layer needs to find k such subsets from the inner layer. So it becomes k * 2^n . 
//space:O(n);space complexity is depth of recursion O(2*k) + visited array O(n) i.e, O(n)visited array O(n) i.e, O(n)
