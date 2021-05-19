public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 : part1Ret) {
                    for (Integer p2 : part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}
//idea: recursive(divide and conquer)
//time: O(3^N)
//If we add a memory to remember the result for any substr, I feel it will reduce to O(N^3) time, where N is the number of numbers in the string.
// Here is the proof: a substr must start from index i and end at index j, so totally N^2 possibilities. For each of the function call, we need to loop for the last ops points, which is O(N) time, so totally O(N^3) time. 
//space:O(N)
//https://leetcode.com/problems/different-ways-to-add-parentheses/discuss/66328/A-recursive-Java-solution-(284-ms)
// 然后我们来进行 分治算法三步走：
// 分解：按运算符分成左右两部分，分别求解
// 解决：实现一个递归函数，输入算式，返回算式解
// 合并：根据运算符合并左右两部分的解，得出最终解
