import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static class RotatePoint{
        int r,c,s;

        public RotatePoint(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }


    static int N,M,K;
    static int[][] arr;
    static RotatePoint[] rotatePoints;
    static int[] result; //순열의 결과를 저장
    static boolean[] isSelected; //순열에서 이미 선택된 요소 체크
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        rotatePoints = new RotatePoint[K];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            rotatePoints[i] = new RotatePoint(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        result= new int[K];
        isSelected = new boolean[K];
        permu(0);

        System.out.println(minResult);

        
    }

    private static void permu(int cnt) {

        if(cnt==K){
            //System.out.println(Arrays.toString(result));

            //0. 배열 복사하기
            int[][] copyArr = deepCopy();

            //1.K만큼 배열 돌리기 반본
            for(int i=0;i<K;i++){
                rotate(rotatePoints[result[i]].r,rotatePoints[result[i]].c,rotatePoints[result[i]].s,copyArr);
                //printArr(copyArr);
            }
            //2.배열의 행의 최대값 찾기
            int tmpSum = arrMinRowSum(copyArr);
           // System.out.println(tmpSum);
            if(minResult > tmpSum) minResult=tmpSum;

            return;
        }
        for(int i=0;i<K;i++){
            if(isSelected[i]) continue;

            isSelected[i] = true;
            result[cnt] =i;
            permu(cnt+1);
            isSelected[i] = false;
        }
    }

    private static void rotate(int r, int c, int s, int[][] copyArr) {

        for(int k=1;k<=s;k++){

            int si=r-k, sj = c-k, ei = r+k, ej= c+k;

            int tmp = copyArr[si][sj];
            //위로 밀기
            for(int i=si;i<ei;i++){
                copyArr[i][sj] = copyArr[i+1][sj];
            }

            //왼쪽으로 밀기
            for(int j= sj;j<ej;j++){
                copyArr[ei][j] = copyArr[ei][j+1];
            }

            //아래로 밀기
            for(int i=ei;i>si;i--){
                copyArr[i][ej] = copyArr[i-1][ej];
            }

            //오른쪽으로 밀기
            for(int j= ej;j>sj;j--){
                copyArr[si][j] = copyArr[si][j-1];
            }

            copyArr[si][sj+1] = tmp;
        }
    }

    private static int[][] deepCopy() {
        int[][] tmp = new int[N+1][];
        for(int i=1;i<=N;i++)
            tmp[i] = Arrays.copyOf(arr[i],arr[i].length);

        return tmp;
    }


    private static int arrMinRowSum(int[][] tmp){

        int min =Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            int sum=0;
            for(int j=1;j<=M;j++){
                sum+= tmp[i][j];
            }
            if(sum<min) min=sum;
        }
        return min;

    }

    private static void printArr(int[][] tmp){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}