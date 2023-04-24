import java.util.*;


class Solution {
    static boolean[] visit;
    static int[][] arr;
    static int N;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
    
        visit = new boolean[n];
        arr = computers;
        N=n;
        
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
    static void dfs(int n){
        visit[n] = true;
        for(int i=0;i<N;i++){
            if(arr[n][i]==1 && !visit[i]){
                visit[i] = true;
                dfs(i);
            }
        }
    }
}