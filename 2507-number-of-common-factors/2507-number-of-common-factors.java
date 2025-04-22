public class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;
        int gcd = findGCD(a, b);
        for (int i = 1; i <= gcd; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
