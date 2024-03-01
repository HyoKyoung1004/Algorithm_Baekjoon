import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M, max;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dfs(i,j,0,0);
                woo(i,j);
            }
        }
        System.out.println(max);
    }

    private static void woo(int i, int j) {

        int[][][] wooTetromino = new int[4][][];
        wooTetromino[0] = new int[][]{{0,0},{0,1},{0,2},{1,1}};//ㅜ
        wooTetromino[1] = new int[][]{{0,0},{1,0},{2,0},{1,1}};//ㅏ
        wooTetromino[2] = new int[][]{{0,1},{1,1},{2,1},{1,0}};//ㅓ
        wooTetromino[3] = new int[][]{{1,0},{1,1},{1,2},{0,1}};//ㅗ

        for(int k=0;k<4;k++){
            int sum=0;
            for(int d=0;d<4;d++){
                int nextX = i + wooTetromino[k][d][0];
                int nextY = j+ wooTetromino[k][d][1];
                if(nextX < 0 || nextX >= N || nextY <0 || nextY>=M ){
                    sum=0;
                    break;
                }else sum+= arr[nextX][nextY];
            }
            if(sum>max)max=sum;
        }
    }

    private static void dfs(int i, int j, int cnt, int sum) {

        visit[i][j] = true;
        sum+= arr[i][j];

        if(cnt==3){
               if(sum>max)max=sum;
                visit[i][j] = false;
               return;
        }
        for(int d=0;d<4;d++){
            int nextX = i + dx[d];
            int nextY = j+ dy[d];
            if(nextX < 0 || nextX >= N || nextY <0 || nextY>=M || visit[nextX][nextY]) continue;
            dfs(nextX, nextY, cnt+1, sum);
        }
        visit[i][j]=false;
    }
}
