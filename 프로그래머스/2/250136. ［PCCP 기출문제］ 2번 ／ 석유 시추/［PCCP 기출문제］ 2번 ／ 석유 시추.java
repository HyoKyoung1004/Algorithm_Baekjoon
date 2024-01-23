import java.util.*;

class Solution {

    static int[][] land, landNum;
    static ArrayList<Integer> count;
    static boolean[][] visit;
    static int N,M;
    public int solution(int[][] land) {
        N = land.length;
        M=land[0].length;
        this.land = land;
        landNum = new int[N][M];
        visit = new boolean[N][M];
        count= new ArrayList<>();
        count.add(0);
        
//         //전체 bfs();
        int c=1;
        for(int i=0;i<N;i++){
            for(int j=0; j<M;j++){
                if(land[i][j]==1 && !visit[i][j]){
                    int blockCount=bfs(i,j, c);
                    count.add(c, blockCount);
                    c++;
                    
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(landNum));
        // System.out.println(count);
        
        int max = 0;
        for(int j=0;j<M;j++){
            Set<Integer> set = new HashSet<>();
            int sum=0;
            for(int i=0;i<N;i++){
                if(landNum[i][j]!=0) 
                    set.add(landNum[i][j]);
            }
            for(int tmp : set){
                sum+= count.get(tmp);
            }
            if(max<sum) max=sum;
        }
        
        return max;
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int bfs(int i, int j,int c){
        
        int blockCount=0;
        
        Queue<int[]> q = new LinkedList<>();
        visit[i][j]=true;
        landNum[i][j]=c;
        q.add(new int[]{i,j});
        
        
        while(!q.isEmpty()){
            
            int[] now = q.poll();
            blockCount++;
            
            for(int d=0;d<4;d++){
                int nextX = now[0] + dx[d];
                int nextY = now[1] + dy[d];
                
                if(nextX <0 || nextX >=N || nextY<0 || nextY >=M || 
                   land[nextX][nextY] ==0 || visit[nextX][nextY] ) continue;
                
                visit[nextX][nextY] =true;
                landNum[nextX][nextY]=c;
                q.add(new int[]{nextX, nextY});
            }
        }
        
        return blockCount;
        
    }
}

