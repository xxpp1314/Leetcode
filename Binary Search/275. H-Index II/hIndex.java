class Solution {
    public int hIndex(int[] citations) {
        int left=0, len = citations.length, right= len-1,  mid;
        while(left<=right)
        {
            mid=(left+right)>>1;
            if(citations[mid]== (len-mid)) return citations[mid];
            else if(citations[mid] > (len-mid)) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;
    }
}
//idea:binary search
//time:O(logn)
//space:O(1)
