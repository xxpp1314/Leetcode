class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int res = 0;
        int presum = 0;
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        for(int i = n - 1; i >= 0; i--){
            int cur = satisfaction[i];
            if(presum + cur > 0){
                presum += cur;
                res += presum;
            }
            else{
                break;
            }
        }
        return res;
    }
}
//idea:greedy algorithm
//time:O(N)
//space:O(1)
