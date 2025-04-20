class Solution {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        int n = nums.length;
        
        for (int bit = 0; bit < 32; bit++) {
            int bitCount = 0;
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    bitCount++;
                }
            }
            
            if (bitCount > 0) {
                result |= (1 << bit);
            }
        }
        
        result *= (1 << (n - 1));
        
        return result;
    }
}
