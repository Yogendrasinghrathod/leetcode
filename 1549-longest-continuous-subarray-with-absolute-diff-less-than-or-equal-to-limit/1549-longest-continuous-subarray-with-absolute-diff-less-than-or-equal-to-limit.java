
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) minDeque.pollLast();
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) maxDeque.pollLast();
            
            minDeque.addLast(nums[right]);
            maxDeque.addLast(nums[right]);

            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (minDeque.peekFirst() == nums[left]) minDeque.pollFirst();
                if (maxDeque.peekFirst() == nums[left]) maxDeque.pollFirst();
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
