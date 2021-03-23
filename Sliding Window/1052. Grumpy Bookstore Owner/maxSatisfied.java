class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0;
        int max = 0;
        int cur = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                satisfied += customers[i];
            }
            else{
                cur += customers[i];
            }
            if(i >= X){
                cur -= customers[i - X] * grumpy[i - X];
            }
            max = Math.max(cur, max);
        }
        return satisfied + max;
    }
}
//idea: sliding window
//time:O(n)
//space: O(1), where n = grumpy.length = customers.length
