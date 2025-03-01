class Solution {
    int[][] pascal;
    int MOD=(1000000007);
    public int numOfWays(int[] nums) {
        int n=nums.length;
        pascal=new int[n][n];
        pascal[0][0]=1;
        for(int i=1;i<n;i++){
            pascal[i][0]=1;
            for(int j=1;j<=i;j++){
                pascal[i][j]=(pascal[i-1][j]+pascal[i-1][j-1])%MOD;
                
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int nu:nums){
            list.add(nu);
        }
        return dfs(list)-1%MOD;

        
    }
    public int dfs(List<Integer> list){
        if(list.size()<2){
            return 1;
        }
        //relative position maintain krna hai
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();

        //find left and right subtree node (divide and conquer approach)

        for(int n:list){
            if(n>list.get(0)){
                right.add(n);
            }
            else if(n<list.get(0)){
                left.add(n);
            }
        }
        int leftVal=dfs(left);
        int rightVal=dfs(right);

        int total=left.size()+right.size();

        return (int) (((long) leftVal * rightVal) % MOD * pascal[total][right.size()] % MOD);
    }
}