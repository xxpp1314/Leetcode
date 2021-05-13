class Solution {
    public int maxResult(int[] nums, int k) {
		// maintain max elements in queue length of K (window)
		Deque<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			// pick the max number in the window size of K
			int max = queue.isEmpty() ? 0 : nums[queue.peekFirst()];
			// update the max value at the position
			nums[i] = nums[i] + max;
			// If nums[i] is max then remove the min values from queue
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			queue.add(i);
			// keep the window valid, if window size is increased
			while (!queue.isEmpty() && i - queue.peekFirst() + 1 > k) {
				queue.pollFirst();
			}
		}
		return nums[nums.length - 1];
	}
}
//idea:dp+mono-deque
//time:O(N)
//sapce:O(N)
