import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int R,C;
    static char[][] arr;
    static int[][] jvisit;
    static int[][] fvisit;
    static ArrayList<Point> fpList =new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        arr= new char[R][];

        Point jp=null;
        for(int i=0;i<R;i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0;j<C;j++){
                if(arr[i][j] =='J') jp = new Point(i,j);
                if(arr[i][j] =='F') fpList.add(new Point(i,j));
            }
        }

        fvisit = new int[R][C];
        fireBfs();
        jvisit = new int[R][C];
        jBfs(jp);

        searchMin();
        if(min==Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(min);
    }

    private static void searchMin() {
        for(int j=0;j<C;j++){
            if((arr[0][j] =='.'||arr[0][j] =='J' ) && jvisit[0][j]>0 && jvisit[0][j]<min ) min = jvisit[0][j];
            if((arr[R-1][j] =='.'||arr[R-1][j] =='J' ) && jvisit[R-1][j]>0 && jvisit[R-1][j]<min ) min = jvisit[R-1][j];
        }
        for(int j=0;j<R;j++){
            if((arr[j][0] =='.'||arr[j][0] =='J' )&& jvisit[j][0]>0 && jvisit[j][0]<min ) min = jvisit[j][0];
            if((arr[j][C-1]=='.'||arr[j][C-1] =='J' )&& jvisit[j][C-1]>0 && jvisit[j][C-1]<min ) min = jvisit[j][C-1];
        }
    }

    private static void jBfs(Point jp) {

        Queue<Point> q= new LinkedList<>();
        q.offer(jp);
        jvisit[jp.x][jp.y] = 1;

        while(!q.isEmpty()){

            Point now = q.poll();
            int nowCount = jvisit[now.x][now.y];

            for (int d = 0; d < 4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && jvisit[nextX][nextY]==0 &&arr[nextX][nextY] =='.'
                && (( fvisit[nextX][nextY] >0 && nowCount+1 < fvisit[nextX][nextY] ) || fvisit[nextX][nextY] ==0) ){
                    q.offer(new Point(nextX,nextY));
                    jvisit[nextX][nextY] = nowCount+1;
                }
            }
        }
    }

    private static void fireBfs() {

        Queue<Point> q= new LinkedList<>();

        for(int k=0;k<fpList.size();k++){
            q.offer(fpList.get(k));
            fvisit[fpList.get(k).x][fpList.get(k).y] = 1;
        }

        while(!q.isEmpty()){

            Point now = q.poll();
            for (int d = 0; d < 4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && fvisit[nextX][nextY]==0 &&(arr[nextX][nextY] =='.' ||arr[nextX][nextY] =='J' )){
                    q.offer(new Point(nextX,nextY));
                    fvisit[nextX][nextY] = fvisit[now.x][now.y]+1;
                }
            }
        }
    }
}