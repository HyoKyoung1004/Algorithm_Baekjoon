import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] arr;
    static boolean[] visit = new boolean[30];
    static int cnt=0;

    static int[] dx ={-1,0,1,0};
    static int[] dy={0,1,0,-1};

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());

        arr= new char[R][C];

        for(int i=0;i<R;i++)
            arr[i] = br.readLine().toCharArray();

        dfs(0,0,1);
        System.out.println(cnt);

    }


    private static void dfs(int x, int y,int count){


        if(count>cnt)cnt = count;

        visit[arr[x][y]-'A']=true;

        for(int i=0;i<4;i++){

            int nextX= x+dx[i];
            int nextY = y+dy[i];

            if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && !visit[arr[nextX][nextY]-'A']){
               dfs(nextX,nextY,count+1);
            }
        }
        visit[arr[x][y]-'A']=false;

    }

}