class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int left = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    left = i;
                }
                else{
                    stack.pop();
                    if(stack.isEmpty()){
                        res = Math.max(res, i - left);
                    }
                    else{
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
//idea: stack
//time:O(N)
//space:O(1)
