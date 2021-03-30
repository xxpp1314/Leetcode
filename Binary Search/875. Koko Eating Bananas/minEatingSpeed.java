class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = (int)1e9;
        //int right = 1000000000;
        while(left < right){
            int mid = left + (right - left) / 2;
            int total = 0;
            for(int pile : piles){
                total += (pile + mid - 1) / mid;
            }
            if(total > h){
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
//Time Complexity: O(NlogW), where N is the number of piles, and W is the maximum size of a pile.
//Space Complexity: O(1).
