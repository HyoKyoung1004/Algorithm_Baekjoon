import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x, y, key;

        public Point(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", key=" + key +
                    '}';
        }
    }
    static int N,M;
    static char[][] arr;
    static boolean visit[][][];
    static Point start;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for(int i=0; i<N;i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                if(arr[i][j]=='0') start = new Point(i,j,0);
            }
        }

        visit = new boolean[N][M][64];
        int ans = bfs();
        System.out.println(ans);
    }

    static int[] dx = {-1,0,1,0};
    static int[] dy= {0,1,0,-1};
    private static int bfs() {

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        arr[start.x][start.y]='.';
        visit[start.x][start.y][start.key]= true;
        int result=0;

        while(!q.isEmpty()){
           //System.out.println(q);
            int size = q.size();
            for(int s=0;s<size;s++){
                Point now = q.poll();
                if(arr[now.x][now.y]=='1'){
                    return result;
                }

                for(int d=0;d<4;d++){
                    int nextX= now.x+dx[d];
                    int nextY = now.y+dy[d];
                    if(nextX<0 || nextX>=N || nextY<0 || nextY>=M || arr[nextX][nextY]=='#') continue;

                    if((arr[nextX][nextY]=='.' ||arr[nextX][nextY]=='1' )&& !visit[nextX][nextY][now.key]) {
                        visit[nextX][nextY][now.key]=true;
                        q.add(new Point(nextX,nextY, now.key));
                    }
                    else if(arr[nextX][nextY]>='a' && arr[nextX][nextY]<='f' && !visit[nextX][nextY][now.key]){
                        int keyNum =arr[nextX][nextY]-'a';
                        int nextKey = now.key | (1<<keyNum);
                        visit[nextX][nextY][now.key] =true;
                        visit[nextX][nextY][nextKey]=true;
                        q.add(new Point(nextX,nextY, nextKey));
                       // arr[nextX][nextY]='.';//벽으로 변경
                    }else if(arr[nextX][nextY]>='A' && arr[nextX][nextY]<='F' && !visit[nextX][nextY][now.key]){
                        int keyNum =arr[nextX][nextY]-'A';
                       // System.out.println(arr[nextX][nextY]+" "+keyNum+" "+ now.key);
                        if((now.key & (1<<keyNum)) != 0){ //키가 있으면
                            q.add(new Point(nextX,nextY, now.key));
                            //System.out.println(keyNum+" ");
                        }
                        visit[nextX][nextY][now.key]=true;
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
