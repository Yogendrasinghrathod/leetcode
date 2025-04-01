class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int [] ans=new int[nums.length];
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int elemSearch=target-nums[i];
            if(map.containsKey(elemSearch)){
                return new int[]{i,map.get(elemSearch)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}