class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, (a,b)->Integer.compare(a[1], b[1]));
        int arrayPos = points[0][1];
        int count = 1;
        for(int i = 1; i < points.length; i++){
            if(arrayPos >= points[i][0]){
                continue;
            }
            count++;
            arrayPos = points[i][1];
        }
        return count;
    }
}
//idea:greedy algorithm, interval array
//Time complexity : O(NlogN) because of sorting of input data.
//Space complexity : O(N) or O(logN)
