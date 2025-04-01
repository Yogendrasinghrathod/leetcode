class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int smallest=Integer.MAX_VALUE;

        if(nums.length<2){
            return nums[0];
        }

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[start]<=nums[mid]){
                //this means left part is sorted so we take the smallest element from this and ignore rest
                smallest=Math.min(smallest,nums[start]);
                start=mid+1;
            }
            else{
                //this means right part is sorted so we take smallest i.e mid and ignore rest
                smallest=Math.min(smallest,nums[mid]);
                end=mid-1;
            }
        }
        return smallest;
    }
}