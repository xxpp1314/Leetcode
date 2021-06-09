class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = nums.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a % 2 == 1) a *= 2;
            pq.add(-a);
            mi = Math.min(mi, a);
        }
        while (true) {
            int a = -pq.poll();
            res = Math.min(res, a - mi);
            if (a % 2 == 1) break;
            mi = Math.min(mi, a / 2);
            pq.add(-a / 2);
        }
        return res;
    }
}
//not understand
//https://leetcode.com/problems/minimize-deviation-in-array/discuss/952857/JavaC%2B%2BPython-Priority-Queue
