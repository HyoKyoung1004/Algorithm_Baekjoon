import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] arr;

    static int[] dx ={-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][];
        for(int i=0;i<N;i++)
            arr[i] = br.readLine().toCharArray();

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == '1'){
                    cnt=0;
                    bfs(i,j);
                    result.add(cnt);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for(int tmp:result)
            System.out.println(tmp);
    }


    private static void bfs(int i, int j) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i,j));
        arr[i][j] ='0';

        while (!q.isEmpty()){
            cnt++; //꺼내면서 개수 세기
            Point now  = q.poll();

            for(int d=0;d<4;d++){
                int nextX= now.x+dx[d];
                int nextY= now.y+dy[d];
                if(nextX < 0 || nextX >=N || nextY<0 || nextY >=N || arr[nextX][nextY]=='0')
                    continue;
                arr[nextX][nextY] ='0';
                q.add(new Point(nextX,nextY));
            }
        }

    }
}