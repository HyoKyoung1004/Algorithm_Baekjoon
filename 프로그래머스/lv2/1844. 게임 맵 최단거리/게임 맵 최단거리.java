import java.util.*;
class Solution {
    
    static int[][] visit;
    static int X,Y;
    public int solution(int[][] maps) {
        int answer = 0;
        X = maps.length;
        Y = maps[0].length;
        visit = new int[X][Y];
        bfs(0,0,maps);
        
        if(visit[X-1][Y-1] ==0){
                answer=-1;
        }else{
            answer =visit[X-1][Y-1];
        }
        
        // for(int i=0;i<X;i++){
        //     for(int j=0;j<Y;j++){
        //         System.out.print(visit[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return answer;
    }
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static void bfs(int x, int y, int[][] maps ){
        visit[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==X-1 && now[1] ==Y-1){
                return;
            }
            for(int d=0;d<4;d++){
                int nextX = now[0]+dx[d];
                int nextY = now[1]+dy[d];
                if(nextX>=0 && nextX<X && nextY>=0 && nextY<Y && maps[nextX][nextY]==1 &&visit[nextX][nextY]==0) {
                    visit[nextX][nextY] = visit[now[0]][now[1]]+1;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
        
    }
}