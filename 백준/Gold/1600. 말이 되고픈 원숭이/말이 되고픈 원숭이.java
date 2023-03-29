import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H;
    static int[][] arr;
    static boolean[][][] visit;
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K= Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W][H];
        visit = new boolean[W][H][K+1];

        for(int i=0;i<W;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<H;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        if(result==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);

    }

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[] horseDx = {-2,-1,1,2,2,1,-1,-2};
    static int[] horseDy = {1,2,2,1,-1,-2,-2,-1};

    private static void bfs() {

        Queue<Po> q = new LinkedList<>();
        q.add(new Po(0,0,0,0));
        visit[0][0][0]=true;

        while(!q.isEmpty()){

            Po now = q.poll();

            if(now.x == W-1 && now.y == H-1){
                result = Math.min(result, now.dis);
                return;
            }

            for(int i=0;i<4;i++){
                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];
                if(nextX>=0 && nextY>=0 && nextX<W && nextY<H && arr[nextX][nextY]==0 && !visit[nextX][nextY][now.k]) {
                    visit[nextX][nextY][now.k] = true;
                    q.add(new Po(nextX, nextY, now.dis + 1, now.k));
                }
            }

            for(int i=0;i<8;i++){
                int nextX = now.x+horseDx[i];
                int nextY = now.y+horseDy[i];
                if(nextX>=0 && nextY>=0 && nextX<W && nextY<H && arr[nextX][nextY]==0 && now.k+1 <= K && !visit[nextX][nextY][now.k+1]) {
                    visit[nextX][nextY][now.k+1] = true;
                    q.add(new Po(nextX, nextY, now.dis + 1, now.k+1));
                }
            }

        }
    }

}
class Po{
    int x,y,dis,k;
    public Po(int x, int y, int dis, int k) {
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.k = k;
    }
}