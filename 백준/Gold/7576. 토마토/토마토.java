import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N,M;
    static int[][] arr;
    static int[][] visit;
    static ArrayList<Point> ripeTomato = new ArrayList<>();
    static int[] dx ={-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());
        M= Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer( br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) ripeTomato.add(new Point(i,j));
            }
        }

        bfs();
        //calMax();
        System.out.println(calMax());


    }

    private static int calMax() {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visit[i][j]==0 && arr[i][j]==0){
                    return -1;
                }
                if(visit[i][j]>max && arr[i][j]==0){
                    max = visit[i][j];
                }
            }
        }
        if( max == Integer.MIN_VALUE) return 0;
        return max-1;
    }

    private static void bfs() {

        Queue<Point> q = new LinkedList<>();
        visit = new int[N][M];

        for(int i=0;i<ripeTomato.size();i++){
            Point tmp =ripeTomato.get(i);
            q.add(tmp);
            visit[tmp.x][tmp.y]=1;
        }

        while(!q.isEmpty()){

            Point now =q.poll();
            for(int d=0;d<4;d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && arr[nextX][nextY] == 0 && visit[nextX][nextY] == 0) {
                    visit[nextX][nextY] = visit[now.x][now.y] + 1;
                    q.add(new Point(nextX, nextY));
                }
            } //4방
        }//empty q
    }
}