class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int mct = 0;
        for(int i = 0; i < arr.length; i++){
            while(arr[i] >= stack.peek()){
                mct += stack.pop() * Math.min(arr[i], stack.peek());
            }
            stack.push(arr[i]);
            
        }
        while(stack.size() > 2){
            mct += stack.pop() * stack.peek();
        }
        return mct;
    }
}
//idea: Monotonic stack;采用单调栈原因：因为非叶节点都是左右叶子节点中最大的那个的乘积. 放在底部那两个里面大的那个必然会被每次都使用, 越靠下使用的次数越多, 肯定要选最小的值往下放, 才能让 mct 尽量小. 
// time:O(n ^ 2)
// space:O(n)
// class Solution {
//      public int mctFromLeafValues(int[] arr) {
//         int n = arr.length;
//             //这道题的核心是:
//             //要知道中序遍历就决定了arr数组（0...n-1）里的第k位元素的所有左边元素（包括它自己）都在左子树里，而其右边元素都在右子树里
//             //而此时左右两边子树分别选出最大值的乘积就是此时的根，也就是题目中说的非叶节点
//             //所以我们可以假定从i到j位，最小和可能是：此刻k位左右两边元素中最大值的乘积 + 子问题k左边(i,k)的最小值 + 子问题k位右边(k+1,j)的最小值
//             //即：dp[i][j]=min(dp[i][j], dp[i][k] + dp[k+1][j] + max[i][k]*max[k+1][j])
//             //这道题跟leetcode1039一个套路
//             //求arr从i到j之间的元素最大值, 保存在max[i][j]中
//             //这道题i和j是可以相等的
//             int[][] max = new int[n][n];
//             for (int j=0;j<n;j++) {
//                 int maxValue = arr[j];
//                 for (int i=j;i>=0;i--) {
//                     maxValue = Math.max(maxValue, arr[i]);
//                     max[i][j] = maxValue;
//                 }
//             }
//             int[][] dp = new int[n][n];
//             for (int j=0; j<n; j++) {
//                 for (int i=j; i>=0; i--) {
//                     //k是i到j之间的中间某个值,i<=k<j
//                     int min = Integer.MAX_VALUE;
//                     for (int k=i; k+1<=j; k++) {
//                        min = Math.min(min,dp[i][k] + dp[k+1][j] + max[i][k]*max[k+1][j]);
//                        dp[i][j] = min;
//                     }
//                 }
//             }
//             return dp[0][n-1];
//     }
// }
