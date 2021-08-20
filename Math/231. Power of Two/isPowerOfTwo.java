class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }
        return (n & (n-1)) ==0;
    }
}
//idea:math;if n is power  of  2 ,n just has one bit is 1
//time:O(1)
//space:O(1)
