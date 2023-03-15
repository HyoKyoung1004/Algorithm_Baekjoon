import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        arr= new char[N][N];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }

        visit = new boolean[N][N];
        int generalCount = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j,true);
                    generalCount++;
                }
            }
        }

        visit = new boolean[N][N];
        int RGCount = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j,false);
                    RGCount++;
                }
            }
        }

        System.out.println(generalCount+" "+RGCount);
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy={0,1,0,-1};


    static void bfs(int x, int y, boolean general){

        Queue<Point> q = new LinkedList<>();
        visit[x][y] =true;
        q.offer(new Point(x,y));

        while(!q.isEmpty()){

            Point now  = q.poll();

            for(int i=0;i<4;i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];


                if(general) {
                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextX][nextY]
                            && arr[nextX][nextY] == arr[now.x][now.y]) {
                        q.offer(new Point(nextX, nextY));
                        visit[nextX][nextY] = true;
                    }
                }else{
                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextX][nextY]) {
                        if((arr[now.x][now.y] == 'R' || arr[now.x][now.y] == 'G') &&(arr[nextX][nextY] == 'R' || arr[nextX][nextY] == 'G')){
                            q.offer(new Point(nextX, nextY));
                            visit[nextX][nextY] = true;
                        }
                        else if(arr[now.x][now.y] == 'B' && arr[nextX][nextY] == 'B'){
                            q.offer(new Point(nextX, nextY));
                            visit[nextX][nextY] = true;
                        }

                    }
                }
            } //4방탐색하여 큐에 넣기 end

        } //큐가 비어있지 않으면 end
    }
}