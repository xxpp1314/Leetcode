class Solution {
    public int jump(int[] nums) {
        //conner case
        if(nums.length < 2){
            return 0;
        }
        int jump = 0;
        int curFarest = 0;
        int curEnd = 0;
        for(int i = 0; i < nums.length - 1; i++){
            curFarest = Math.max(curFarest, i + nums[i]);
            if(i == curEnd){
                jump++;
                curEnd = curFarest;
            }
            //add some code to jump out early.
            // if(curEnd >= nums.length - 1){
            //     break;
            // }
        }
        return jump;
    }
}
//idea: greedy
//The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarest is the farest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarest, then keep the above steps, as the following:
//time:O(N)
//space:O(1)
