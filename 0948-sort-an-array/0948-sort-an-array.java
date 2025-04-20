class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return; // Base case: array of size 1 or 0 is already sorted
        
        int mid = left + (right - left) / 2;
        
        mergeSort(nums, left, mid); // Sort the left half
        mergeSort(nums, mid + 1, right); // Sort the right half
        
        merge(nums, left, mid, right); // Merge the two sorted halves
    }
    
    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data into temporary arrays
        System.arraycopy(nums, left, leftArray, 0, n1);
        System.arraycopy(nums, mid + 1, rightArray, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k++] = leftArray[i++];
            } else {
                nums[k++] = rightArray[j++];
            }
        }
        
        // Copy any remaining elements from the left array
        while (i < n1) {
            nums[k++] = leftArray[i++];
        }
        
        // Copy any remaining elements from the right array
        while (j < n2) {
            nums[k++] = rightArray[j++];
        }
    }
}
