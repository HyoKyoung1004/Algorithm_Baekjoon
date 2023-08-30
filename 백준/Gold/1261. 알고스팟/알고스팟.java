import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point>{
        int x, y, w;

        public Point(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.w-o.w;
        }
    }

    static int N, M;
    static int[][] arr, dist;
    static boolean[][] visit;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static final int INF =Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];

        for(int i=0;i<M;i++){
            String str = br.readLine();
            for(int j=0; j<N;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        dist = new int[M][N];
        visit = new boolean[M][N];

        for(int i=0;i<M;i++){
            Arrays.fill(dist[i],INF);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0));

        while(!pq.isEmpty()){

            Point now = pq.poll();
            if(visit[now.x][now.y]) continue;

            visit[now.x][now.y] = true;
            dist[now.x][now.y] = now.w;

            if(now.x == M-1 && now.y ==N-1) break;

            for(int i=0;i<4;i++){

                int nextX = now.x+dx[i];
                int nextY = now.y+dy[i];

                if(nextX<0 || nextX>=M || nextY<0 || nextY>=N) continue;

                if(dist[nextX][nextY] > now.w + arr[nextX][nextY]){
                    pq.add(new Point(nextX, nextY, now.w + arr[nextX][nextY]));
                }
            }
        }
        System.out.println(dist[M-1][N-1]);
    }

}