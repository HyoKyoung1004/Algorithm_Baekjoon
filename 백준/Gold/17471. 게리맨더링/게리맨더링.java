import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; //구역 수
    static ArrayList<Integer>[] graph; // 그래프를 저장할 배열
    static int[] popul; //인구를 저장할 배열

    static int end; //조합을 끝낼 자리수
    static int[] result;//조합의 결과를 저장할 배열

    static int[] groupB;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        //인구 수 받기
        popul = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            popul[i] = Integer.parseInt(st.nextToken());
        }

        //무향 그래프 저장하기
        graph = new ArrayList[N+1];//구역 변호는 1부터
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int k=0;k<num;k++){
                int to = Integer.parseInt(st.nextToken());
                graph[i].add(to);
            }
        }

        //---------input -----------------------------------------

        //두 그룹으로 나눈다.
        int A = N/2;
        int B= N-A;

        while(A>0 && B<=N){
            //각 그룹에 선택된 사람을 뽑는 조합을 시작한다.
            end =A;
            result = new int[end];
            //System.out.println(end+"명 뽑기 조합");
            combi(0,1);//조합의 자리수, 시작번호, 끝을 낼 자리수;
            //System.out.println();
            A--;
            B++;
        }

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }

    private static void combi(int cnt, int start) {


        if(cnt==end){

            boolean[] BChecker = new boolean[N+1];
            for(int i=0;i<end;i++){
                BChecker[result[i]]=true;
            }
            int k=0;
            groupB = new int[N-end];
            for(int i=1;i<=N;i++){
                if(!BChecker[i]){
                    groupB[k++] = i;
                }
            }

           //System.out.println(Arrays.toString(result)+" "+Arrays.toString(groupB));

            //0. 연결유무 확인
            if(connectingCheck()){

                //두 선서구의 포함된 인구 차이의 초솟값 구하기
                int sum1 =0;
                for(int i=0;i<end;i++){
                    sum1+= popul[result[i]];
                }

                int sum2 =0;
                for(int i=0;i<N-end;i++){
                    sum2+= popul[groupB[i]];
                }

                int diff = Math.abs(sum1-sum2);
               // System.out.println(diff);

                if(min >diff) min =diff;


            }

            return;
        }

        for(int i=start;i<=N;i++){
            result[cnt] =i;
            combi(cnt+1,i+1);
        }
    }

    static int cnt;
    static boolean visit[];
    static int bfsEnd;
    static int[] Now;
    static boolean bfsResult;
    private static boolean connectingCheck() {

        boolean group1 =false;
        boolean group2 =false;

        bfsEnd = end;
        Now = result;
        for(int i=0;i<end;i++){
            if(!group1){
             visit = new boolean[N+1];
             cnt=0;
             bfsResult =false;
             dfs(result[i]);
             group1 = bfsResult;
            }
        }

        if(!group1) return false;

        bfsEnd = N-end;
        Now = groupB;
        for(int i=0;i<N-end;i++){
            if(!group2){
                visit = new boolean[N+1];
                cnt=0;
                bfsResult =false;
                dfs(groupB[i]);
                group2 = bfsResult;
            }
        }
       //System.out.println(group1+"  "+group2);

        return group1 && group2;
    }

    private static void dfs(int n) {

        visit[n] = true;
        cnt++;
        if(cnt == bfsEnd){
            bfsResult =true;
            return;
        }

        for(int tmp : graph[n]){
            //같은 그룹이고 방문하지 않았다를 어케 표현함?
            if(!visit[tmp] && Arrays.binarySearch(Now,tmp) >=0 )
               dfs(tmp);
        }

    }
}