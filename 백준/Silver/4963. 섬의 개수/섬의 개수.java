import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w, h;
    static int[][] arr;
    static int cnt;

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};


    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            arr = new int[h][w];
            for(int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cnt=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(arr[i][j]==1){
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
            result.add(cnt);

        }//테케반복 끝
        for (int tmp :result)
            System.out.println(tmp);
    }

    private static void dfs(int i, int j) {

        arr[i][j] = 0; //방문처리

        for(int d=0;d<8;d++){
            int nextX= i+dx[d];
            int nextY= j+dy[d];

            if(nextX<0 || nextX>=h || nextY<0|| nextY>=w || arr[nextX][nextY]==0)
                continue;

            arr[nextX][nextY]=0;
            dfs(nextX,nextY);
        }
    }
}