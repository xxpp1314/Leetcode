class Solution {
    public int minimumEffort(int[][] tasks) {
        int res = 0;
        Arrays.sort(tasks, (a1, a2) -> (a1[1] - a1[0]) - (a2[1] - a2[0]));
        for (int[] task : tasks) {
            res = Math.max(res + task[0], task[1]);
        }
        return res;
    }
}
//idea:greedy algorithm
//time:O(N)
//space:O(1)
