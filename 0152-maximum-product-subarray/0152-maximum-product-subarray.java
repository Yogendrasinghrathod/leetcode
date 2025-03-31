class Solution {
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int tempMax = Math.max(current, Math.max(maxProd * current, minProd * current));
            minProd = Math.min(current, Math.min(maxProd * current, minProd * current));
            maxProd = tempMax;

            result = Math.max(result, maxProd);
        }

        return result;
    }
}