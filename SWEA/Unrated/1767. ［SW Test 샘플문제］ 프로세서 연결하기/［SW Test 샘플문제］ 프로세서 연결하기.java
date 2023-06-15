import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class Core{
        int x, y;
        Core(int x, int y){
            this.x=x;
            this.y=y;
        }

        public String toString(){
            return "["+x+", "+y+"] ";
        }
    }

    static int N, coreCount, minLine;
    static int[][] arr;
    static ArrayList<Core> cores;
    static Core[] nowCores;
    static int[] cards;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=TC;tc++){
            N= Integer.parseInt(br.readLine());
            arr = new int[N][N];
            cores = new ArrayList<>();
            StringTokenizer st;

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j]==1 && !(i==0 || i==N-1 || j==0 || j==N-1)){
                        cores.add(new Core(i,j));
                    }
                }
            }

            minLine = Integer.MAX_VALUE;
            coreCount = cores.size();
            visit= new boolean[N][N];
            //연결한 core를 선택한다.
            for(int i=coreCount;i>0;i--) {
                nowCores = new Core[i];
                cards = new int[i];
                if(comb(i,0, 0))
                    break;
            }
            sb.append("#"+tc+" "+minLine+"\n");

        }
        System.out.println(sb);

    }


    //연결을 시도해볼  Core를 선택
    static boolean comb(int total, int cnt, int start){

        if(cnt==total){
           // System.out.println(Arrays.toString(nowCores));
            //상하좌우 4개로 연결시켜 봐야지
            makeLine(0, total);

            if(minLine<Integer.MAX_VALUE)
                return true;
            else return false;
//        return false;
        }

        boolean result =false;
        for(int i=start;i<coreCount;i++){
            nowCores[cnt] = cores.get(i);
            boolean tmp=  comb(total, cnt+1, i+1);
            if(tmp && !result) result=tmp;
        }
        return result;
    }

    private static void makeLine(int cnt, int total) {
        if(cnt==total){
            //전체의 개수세기
            int lineNum=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visit[i][j]) lineNum++;
                }
            }

           // System.out.println(lineNum);
            if(minLine>lineNum) minLine=lineNum;
            return;
        }

        for(int d=0;d<4;d++){
            if(possible(d, cnt)){
                //연결하고
                connectRemoveLine(d, cnt, true);
                 makeLine(cnt+1, total);
                //연결해제
                connectRemoveLine(d, cnt, false);
            }
        }
    }

    static int[] dx = {-1, 0, 1,0};
    static int[] dy={0,1,0,-1};
    private static boolean possible(int d, int cnt) {

        //벽에 안닻게 계속 이동
        int x = nowCores[cnt].x+dx[d];
        int y = nowCores[cnt].y+dy[d];
        while(x>=0 && x<N && y>=0 && y<N){
            if(arr[x][y]!=0 || visit[x][y]) return false;
            x = x+dx[d];
            y= y+dy[d];
        }
        return true;
    }

    private static void connectRemoveLine(int d, int cnt, boolean conOrRem) {

        int x = nowCores[cnt].x+dx[d];
        int y = nowCores[cnt].y+dy[d];
        while(x>=0 && x<N && y>=0 && y<N){
            if(conOrRem) visit[x][y] =true;
            else visit[x][y] =false;
            x = x+dx[d];
            y= y+dy[d];
        }
    }
}
