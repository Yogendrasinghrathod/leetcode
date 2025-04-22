public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long guess = mid * mid;
            if (guess == num) return true;
            if (guess < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
