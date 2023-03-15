import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static Point[] result;  //조합 결과
    static int length; //바이러스 총 개수

    static ArrayList<Point> two = new ArrayList<>(); //바이러스 저장
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        arr= new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] ==2){
                    two.add(new Point(i,j));
                }
            }
        }

        length = two.size();
        result = new Point[M];

        combination(0,0);

        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }

    private static void combination(int cnt, int start) {

        if(cnt == M){

            BFS(result);

            int sum = emptySpace();
            if( sum>=0 && min > sum)  min = sum;
            
            return;
        }

        for(int i=start ;i<length;i++){
            result[cnt] = two.get(i);
            combination(cnt+1, i+1);
        }
    }

    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] visit;
    
    private static void BFS(Point[] result) {

        visit = new int[N][N];

        Queue<int[]> q = new LinkedList();
        
        for(int i=0;i<M;i++){ //조합으로 완성된 바이러스들을 모두 큐에 넣어넣어
            q.offer(new int[]{result[i].x,result[i].y,0 });
        }
        
        while(!q.isEmpty()){

            int[] now = q.poll();

            int x = now[0];
            int y = now[1];
            int value = now[2];

            for(int i=0;i<4;i++){

                int nextX = x+dx[i];
                int nextY = y+dy[i];

                if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && (arr[nextX][nextY]==0 || arr[nextX][nextY]==2) &&
                        visit[nextX][nextY]==0){  //방문하지 않았고, 비활성바이러스이거나 큐이면 탐색할꺼임!!

                    visit[nextX][nextY] = value+1;
                    q.add(new int[]{nextX,nextY,value+1});

                }
            }//4방탐색 끝
        }//큐 반복 끝
    }

    static int emptySpace(){  //빈공간 있는 지 확인과 최대값 찾기
        int max=0;
       for(int i=0;i<N;i++){
           for(int j=0;j<N;j++){
               if(arr[i][j] == 0 && visit[i][j]==0){
                   return -1;
               }
               if(arr[i][j] == 0 &&visit[i][j]>max)
                   max = visit[i][j];

           }
       }
       return max;
    }

}