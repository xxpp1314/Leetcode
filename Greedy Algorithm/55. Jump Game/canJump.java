class Solution {
    public boolean canJump(int[] nums) {
        int maxLocation = 0;
        for(int i = 0; i < nums.length; i++){
// if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
            if(maxLocation < i){
                return false;
            }
            maxLocation = Math.max(maxLocation, i + nums[i]);
        }
        return true;
    }
}
//idea: greedy algorithm
//time:O(N)
//space:O(1)
