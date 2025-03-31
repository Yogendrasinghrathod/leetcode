class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] Prefix=new int[nums.length];
        int [] Suffix=new int[nums.length];
        int[] result=new int[nums.length];
        int n=nums.length;
        Prefix[0]=1;
        Suffix[n-1]=1;

        for(int i=1;i<nums.length;i++){
            Prefix[i]=Prefix[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            Suffix[i]=Suffix[i+1]*nums[i+1];
        }

        for(int i=0;i<nums.length;i++){
            result[i]=Prefix[i]*Suffix[i];
        }
        return result;

        
    }
}