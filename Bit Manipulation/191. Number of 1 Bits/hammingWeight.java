public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0){
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }
}
//idea:math, bit operation; we need to identify unsigned integer and signed integer.
//因此所说的 有符号、无符号 看的就是二进制的符号位， 无符号:就不管符号位，右移只填充0；有符号，就是符号位是啥，我就填充啥，Java中也是同理。
//time:O(N)
//space:O(1)
// The >>> operator is the unsigned right bit-shift operator in Java. It effectively divides the operand by 2 to the power of the right operand, or just 2 here.
// The difference between >> and >>> would only show up when shifting negative numbers. The >> operator shifts a 1 bit into the most significant bit if it was a 1, and the >>> shifts in a 0 regardless.
