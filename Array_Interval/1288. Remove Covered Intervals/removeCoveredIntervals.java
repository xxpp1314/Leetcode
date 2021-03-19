class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int res = 0;
        int left = -1;
        int right = -1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int[] interval : intervals){
            if(interval[0] > left && interval[1] > right){
                left = interval[0];
                res++;
            }
            right = Math.max(right, interval[1]);
        }
        return res;
    }
}
//idea: interval array
//time:O(nlogn)
//space:O(1)
