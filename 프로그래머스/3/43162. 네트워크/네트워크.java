import java.util.*;

class Solution {
    
    static boolean[] visit;
    static int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N=n;
        visit = new boolean[n];
        for(int i=0;i<n;i++){
            
            if(visit[i]) continue;
            bfs(i, computers);
            answer++;
        }    
        return answer;
    }
    
    private void bfs(int k, int[][] arr){
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visit[k]=true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0;i<N;i++){
                if(arr[now][i]==0 || visit[i] ) continue;
                visit[i]=true;
                q.add(i);
            }
        }
    }
}