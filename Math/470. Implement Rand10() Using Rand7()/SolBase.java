/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int result = 40;
        while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
        return result % 10 + 1;
    }
}
//https://leetcode.com/problems/implement-rand10-using-rand7/discuss/150301/Three-line-Java-solution-the-idea-can-be-generalized-to-%22Implement-RandM()-Using-RandN()%22
