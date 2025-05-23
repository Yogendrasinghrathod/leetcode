class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;
        while(right>left){
            ans=Math.max(ans,(Math.min(height[left],height[right])*(right-left)));
            if ((Math.min(height[left],height[right])==height[left])) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
        
    }
}