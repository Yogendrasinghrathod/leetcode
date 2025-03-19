class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] trustcount= new int[n+1];
        int len=trust.length;
        for(int i=0;i<len;i++){
            int src=trust[i][0];
            int dest=trust[i][1];
            trustcount[src]--;
            trustcount[dest]++;

        }

        for(int i=1;i<n+1;i++){
            if(trustcount[i]==n-1){
                return i;
            }
        }
        return -1;


        
    }
}