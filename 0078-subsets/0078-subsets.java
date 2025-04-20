import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));
        
        // Explore further elements to include in the subset
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // Include the current element
            backtrack(nums, i + 1, current, result); // Recur for the next element
            current.remove(current.size() - 1); // Backtrack: remove the last added element
        }
    }
}
