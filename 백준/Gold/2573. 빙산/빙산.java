import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N,M, year, totalCount, nextIce, yearCount;
    static int[][] arr;
    static List<Point> ice;
    static int[] dx = {-1,0,1,0};
    static int[] dy= {0,1,0,-1};
    static boolean[][] visit;
    static Queue<Point> q;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        ice = new LinkedList<>();
        q = new LinkedList<>();
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>0) {
//                    q.add(new Point(i,j, arr[i][j]));
                    totalCount++;
                    if(totalCount==1) q.add(new Point(i,j));
                }
            }
        }


        while(!addYear()){}
        System.out.println(year);

    }


    private static boolean addYear(){

        totalCount=0;
        yearCount=0;
        
        int startX=0, startY=0;
        visit = new boolean[N][M];

        int[][] tmpArr = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]>0) {
                    totalCount++;
                    if(totalCount==1){
                        startX=i;
                        startY=j;
                    }
                }
            }
        }

        if(totalCount==0){
            year=0;
            return true;
        }

        dfs(startX, startY, tmpArr);
        if(totalCount > yearCount) {
            return true;} //2개 이상
        else {
            year++;
            arr = tmpArr;
            return false;
        }//반복해야함

    }

    private static void dfs(int x, int y, int[][] tmpArr) {
        yearCount++;
        visit[x][y]=true;

        int seaCount=0;
        for(int d=0;d<4;d++){
            int nextX = x+dx[d];
            int nextY = y+dy[d];
            if(arr[nextX][nextY]==0) seaCount++;
        }
        if(arr[x][y] - seaCount<=0){
            tmpArr[x][y]=0;
        }else{
            tmpArr[x][y] =arr[x][y] - seaCount;
        }

        for(int d=0;d<4;d++){
            int nextX = x+dx[d];
            int nextY = y+dy[d];
            if(!visit[nextX][nextY] && arr[nextX][nextY]>0)
                dfs(nextX, nextY, tmpArr);
        }
    }
}
