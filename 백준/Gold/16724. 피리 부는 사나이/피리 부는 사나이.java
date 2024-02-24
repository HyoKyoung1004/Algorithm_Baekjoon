import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            char[] in = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                if(in[j]=='U') arr[i][j] =0;
                else if(in[j]=='R') arr[i][j] =1;
                else if(in[j]=='D') arr[i][j] =2;
                else arr[i][j] =3;
            }
        }

        visit = new boolean[N][M];
        int result=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visit[i][j]) {
                    bfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(int i, int j) {

        visit[i][j] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i,j));

        while(!q.isEmpty()){

            Point now = q.poll();

            int nextX = now.x + dx[arr[now.x][now.y]];
            int nextY = now.y + dy[arr[now.x][now.y]];

            if(!visit[nextX][nextY]){
                q.add(new Point(nextX,nextY));
                visit[nextX][nextY]=true;
            }

            for(int d=0;d<4;d++){

                nextX = now.x + dx[d];
                nextY = now.y + dy[d];

                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M || visit[nextX][nextY]) continue;
                if(d== (arr[nextX][nextY]+2)%4){
                    q.add(new Point(nextX,nextY));
                    visit[nextX][nextY]=true;
                }
            }
        }
    }
}
