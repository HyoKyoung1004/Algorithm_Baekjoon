import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[] tasoon;
    static boolean[] visit;

    static int maxScore = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][10];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1;j<=9;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tasoon = new int[10];
        visit = new boolean[10];
        permu(1);
        System.out.println(maxScore);
    }

    private static void permu(int cnt){

       // if(cnt==4) permu(cnt+1);

        if(cnt == 10){
            if(tasoon[4]!= 1) return;

            // System.out.println(Arrays.toString(tasoon));
            int score = calScore();
            if(score >maxScore){
                maxScore = score;
            }
            return;
        }

        for(int i=1;i<=9;i++){

            if(visit[i]) continue;

            visit[i]=true;
            tasoon[cnt] = i;
            permu(cnt+1);
            visit[i]=false;

        }

    }

    private static int calScore() {
        int nowIndex = 1;
        int outCount=0;
        int score=0;

        //int[] baseNumber = new int[5]; //1번, 2번,3번, home

        for(int i=1;i<=N;i++) {
            int[] baseNumber = new int[5];

            while (outCount < 3) {

                int result = arr[i][tasoon[nowIndex]];
                if (result==0){
                    outCount++;
                }else{
                    baseNumber[0]=1;
                    for(int k=1;k<=result;k++){
                        score+=oneStep(baseNumber);
                    }
                    baseNumber[0]=0;
                }

                nowIndex++;
                if(nowIndex==10) nowIndex=1;


            }//아웃카운트 만큼 끝
            outCount=0; //한 이닝 끝났으므로 outCount는 다시 0으로

        }//이닝의 수 만큼 끝

        return score;

    }
    private static int oneStep(int[] baseNumber){
        for(int i=4;i>0;i--){
            baseNumber[i] = baseNumber[i-1];
        }
        baseNumber[0] = 0;
        if(baseNumber[4]>0){ //홈에 왔으면 1점 반환!!
            baseNumber[4]=0;
            return 1;
        }
        return 0;
    }
}