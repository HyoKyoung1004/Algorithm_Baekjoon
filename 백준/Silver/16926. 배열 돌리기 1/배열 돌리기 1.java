import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int R;
    static int[][] arr;

    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min = Math.min(N,M);

        //  toStringTest(arr);

        while (R>0) {
            R--;

            for (int k = 0; k < min / 2; k++) {

                // 1. 아래로 내려간다. 0+k ~ N-1-k

                int tmp = arr[k][k + 1];
                int b;

                for (int i = k; i < N - k; i++) {
                    b = arr[i][k];
                    arr[i][k] = tmp;
                    tmp = b;
                }

//                toStringTest(arr);

                //오른쪽으로 돌리기 고정:열이 N-1-k라는 점
                for (int i = k + 1; i < M - k; i++) {
                    b = arr[N - 1 - k][i];
                    arr[N - 1 - k][i] = tmp;
                    tmp = b;
                }
//                toStringTest(arr);

                //위로 돌리기 고정: 행이 M-1-k
                for (int i = N - k - 1 - 1; i >= k; i--) {
                    b = arr[i][M - 1 - k];
                    arr[i][M - 1 - k] = tmp;
                    tmp = b;
                }
//                toStringTest(arr);

                //왼쪽으로 돌리기 고정 행이 k
                for (int i = M - 1 - k - 1; i >= k; i--) {
                    b = arr[k][i];
                    arr[k][i] = tmp;
                    tmp = b;
                }
//               toStringTest(arr);


            }
        }

        toStringTest(arr);

    }

    private static void toStringTest(int[][] array){

        for(int[] tmp :array) {
            for (int num : tmp){
                sb.append(num+" ");}
            sb.append("\n");
        }
        System.out.println(sb);


//        for(int[] tmp :array) {
//            System.out.println(Arrays.toString(tmp));
//        }
//        System.out.println();

    }


}