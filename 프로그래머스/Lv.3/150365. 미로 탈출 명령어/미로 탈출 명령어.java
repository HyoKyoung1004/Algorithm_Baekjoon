import java.util.*;
class Solution {
    static class Point{
        int x, y;
        String direc;
        public Point(int x, int y, String direc){
            this.x=x;
            this.y=y;
            this.direc=direc;
        }
    }
    static int N, M,X,Y,R,C,K;
    static int[][] visit;
    static String result;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N=n;
        M=m;
        X=x;
        Y=y;
        R=r;
        C=c;
        K=k;
        
        bfs();
        String answer = "";
        return result;
    }
    //방향 시간 순 d l r u
    static int[] dx = {1, 0,0,-1};
    static int[] dy = {0, -1, 1, 0}; 
    static char[] dd = {'d', 'l', 'r', 'u'};
    
    static void bfs (){
        
        visit = new int[N+1][M+1];
        Point start = new Point(X,Y,"");
        Queue<Point> q = new LinkedList<>();
        q.add(start);
    
        int k=0;
        
        while(!q.isEmpty()){
            
            if(k>K){
                result="impossible";
                return;
            }
            
            int size =q.size();
            
            for(int s=0;s<size;s++){
                
                Point now = q.poll();
                if(k==K && now.x ==R && now.y==C){
                    result = now.direc;
                    return;
                }
                
                for(int d=0;d<4;d++){
                    
                    int nextX = now.x +dx[d];
                    int nextY = now.y+dy[d];
                    
                    if(nextX<1 || nextX >N || nextY<1 || nextY>M || visit[nextX][nextY] == k+1 ) continue;
                    
                    visit[nextX][nextY] =k+1;
                    q.add(new Point(nextX, nextY, now.direc+dd[d]));
                    
                } //방향
                
            } //크기만큼
            k++;
        } //while
    }

}