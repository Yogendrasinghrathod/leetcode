public class Solution {
    public int findNthDigit(int n) {
        long length = 1, count = 9, start = 1;
        while (n > length * count) {
            n -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        long num = start + (n - 1) / length;
        String str = String.valueOf(num);
        return str.charAt((int)((n - 1) % length)) - '0';
    }
}
