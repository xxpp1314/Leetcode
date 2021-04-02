class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for(int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }
        while(left < right){
            int mid = left + (right - left) / 2;
            int day = 1;
            int cur = 0;
            for(int weight : weights){
                if(cur + weight > mid){
                    day++;
                    cur = 0;
                }
                cur += weight; 
            }
            if(day > D){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
//idea: binary search
// Time complexity: O(n * logSIZE), where SIZE is the size of the search space (sum of weights - max weight).
// Space complexity: O(1).
