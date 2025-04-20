import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));  // Add the current permutation to result
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip if the element is already in the current permutation
            if (current.contains(nums[i])) continue;
            
            current.add(nums[i]); // Add element to the current permutation
            backtrack(nums, current, result); // Recursively build the next element
            current.remove(current.size() - 1); // Backtrack: remove the last element
        }
    }
}
