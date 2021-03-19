class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        //Arrays.sort(intervals, new myComparator());
        int count = 1;
        int k = 0;
        int n = intervals.length;
        for(int i = 1; i < n; i++){
            if(intervals[i][0] >= intervals[k][1]){
                k = i;
                count++;
            }
        }
        return n - count;
    }
    
    // class myComparator implements Comparator<int[]> {
    //     public int compare(int[] a, int[] b) {
    //       return a[1] - b[1];
    //     }
    // }
}
//idea: interval array
//time:O(nlogn)
//space:O(1)
