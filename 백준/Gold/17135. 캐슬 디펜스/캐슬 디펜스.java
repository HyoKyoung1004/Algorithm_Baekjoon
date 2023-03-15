import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int D;
    static int[][] arr;

    static int[] result;//궁수의 위치다!

    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        D= Integer.parseInt(st.nextToken());


        arr= new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[3];
        comb(0,0);

        System.out.println(max);

    }

    private static void comb(int cnt, int start) {

        if(cnt==3){

            //System.out.println(Arrays.toString(result));

            //0. 배열 복사
            int[][] copyarr = deepCopy(arr);

            int sum =0;
            //1. 아직 적이 있는 지 확인
            while (exist(copyarr)){
                //2. 적이 있다면 가장 가까운 적 죽이고, 죽인 개수 확인
                sum+= bfs(copyarr);

                //3. 한칸 아래로 밀기,,,,
                pushOneRow(copyarr);
            }

            if(sum>max)
                max =sum;
            return;
        }

        for(int i=start; i<M;i++){
            result[cnt] = i;
            comb(cnt+1,i+1);
        }

    }


    //d거리 이하에서 가장 가까운 적 찾아서 죽이장~~!!!!
    static int[] dx= {0,-1,0};
    static int[] dy={-1,0,1};
    private static int bfs(int[][] copyarr){

        int dieNum=0;
        int[][] target = new int[3][2];//죽일 대상을 저장하는 배열,
        for(int i=0;i<3;i++){
            Arrays.fill(target[i],-1);
        }

        //각각 궁수에 대하여 최선의 위치를 찾는다.
        for(int i=0;i<3;i++){

            boolean[][] visit = new boolean[N][M];

            //궁수와 가장 가까운 점을 넣고 시작하자
            Queue<int[]> q= new LinkedList<>();
            q.offer(new int[]{N-1, result[i]});
            visit[N-1][result[i]] = true;

            while(!q.isEmpty()){

                int[] now = q.poll();
                int distance = Math.abs(N-now[0])+ Math.abs(result[i]-now[1]);

                //가장 가까운 적을 찾음
                if(copyarr[now[0]][now[1]] ==1  &&distance <=D){
                    target[i] = now;
                    break;
                }

                if(distance >=D) continue; //거리가 같으므로 더 이상 탐색해도 거리가 늘어날 뿐

                else if(distance <D){

                     //3방탐색
                    for(int d=0;d<3;d++){
                        int nextX= now[0]+dx[d];
                        int nextY = now[1]+dy[d];

                        if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && !visit[nextX][nextY]){
                            visit[nextX][nextY] =true;
                            q.offer(new int[]{nextX,nextY});
                        }
                    }
                }

            }

        }

        for(int i=0;i<3;i++){

            if(target[i][0] ==-1 ||target[i][1] ==-1 ) continue;  //못찾아서 -1들어 있는 거
            if(copyarr[target[i][0]][target[i][1]] == 1){
                dieNum++;
                copyarr[target[i][0]][target[i][1]] =0;
            }
        }
        return dieNum;
    }

    static int[][] deepCopy(int[][] arr){
        int[][] tmp = new int[N][M];
        for(int i=0;i<N;i++){
            tmp[i] = Arrays.copyOf(arr[i],arr[i].length);
        }
        return tmp;
    }

    static boolean  exist(int[][] tmp){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(tmp[i][j] == 1)
                    return true;
            }
        }
        return false;
    }

    private static void pushOneRow(int[][] tmp) {

        for(int i=N-1;i>0;i--){
            for(int j=0;j<M;j++){
                tmp[i][j] = tmp[i-1][j];
            }
        }
        for(int j=0;j<M;j++)
            tmp[0][j] = 0;
    }


}