class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        int provinces=0;
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j]==1){
                    dfs(isConnected,i,j,v);
                    provinces++;
                }
            }
        }
        return provinces;
    }
    public void dfs(int[][]graph,int s, int d,int v){
       graph[s][d]=0;
       for(int i=0;i<v;i++){
        if(graph[d][i]==1){
            dfs(graph,d,i,v);

        }
       }
    }
}