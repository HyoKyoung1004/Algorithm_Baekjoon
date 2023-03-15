import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static class Point implements Comparable<Point>{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" + "x=" + x + ", y=" + y + '}';
        }

        @Override
        public int compareTo(Point o) {
           if(x == o.x) return Integer.compare(y, o.y);
           return Integer.compare(x,o.x);
        }

    }

    static int N;
    static int[][] arr;
    static Point shark; //상어 위치
    static int sharkSize=2;
    static int countfish=0;
    static int time=0;
    static int[] dx ={-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static PriorityQueue<Point> fish; // 동일 시간대의 물고기를 담아둠

    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N= Integer.parseInt(br.readLine());

        arr= new int[N][N];
        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) shark = new Point(i,j);
            }
        }

        search();
        System.out.println(time);


    }

    private static void search() {

       // Queue<Point> fish = new LinkedList<>();
        fish = new PriorityQueue<>();

        while(true){

            int tmpTime = bfs();
            if(!fish.isEmpty()){
                time += tmpTime;
                countfish++;

                arr[shark.x][shark.y] =0;
                shark = fish.poll(); //첫번째 fish를 먹었으므로 자리가 변경됨

                if(countfish ==sharkSize){
                    sharkSize++;
                    countfish=0;
                }
                fish.clear(); //clear 후에 새로운 위치에서 물고기 다시 받아온다.

            }else{
                break;
            }

        }
    }

    private static int bfs() {
        boolean[][] visit = new boolean[N][N];

        Queue<Point> q = new LinkedList<>();
        q.offer(shark);
        visit[shark.x][shark.y]=true;
        int count=0;

        while(!q.isEmpty()){

            int size  = q.size();
            count++;
            for(int i=0;i<size;i++){

                Point now =q.poll();
                for(int d=0;d<4;d++){
                    int nextX = now.x+dx[d];
                    int nextY = now.y+dy[d];

                    if(nextX>=0 && nextX<N && nextY>=0 && nextY<N && arr[nextX][nextY] <= sharkSize && !visit[nextX][nextY]){
                        visit[nextX][nextY]=true;
                        q.add(new Point(nextX,nextY));
                        if(arr[nextX][nextY] !=0  && arr[nextX][nextY]<sharkSize) fish.offer(new Point(nextX,nextY));

                    }
                }//4방 끝
            } //q 사이즈 만큼 끝ㅌ

            if(fish.size()>0) return count;
        }
        return count;

    }
}