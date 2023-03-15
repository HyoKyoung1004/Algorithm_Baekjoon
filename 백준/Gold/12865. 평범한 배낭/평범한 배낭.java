import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] w;
    static int[] v;
    static int n;
    static int k;
    static int[][] dp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //물건 수
        k = Integer.parseInt(st.nextToken()); //무게

        w = new int[n];
        v = new int[n];
        dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());


        }



        //int result = knabsack(n, k);
        int result = buttomUpknabsack(n, k);
       // System.out.println(Arrays.deepToString(dp));

        System.out.println(result);

    }
//    private static int knabsack(int n, int k) {
//
//        if(k<=0||n<=0) return 0;
//
//        if(dp[n][k]==0) { //탐색을 하지 않았다면,,,
//            if (w[n - 1] > k) //만약 물건을 담았을 때 무게합이 나온다면
//                dp[n][k] = knabsack(n - 1, k);
//            else
//                dp[n][k] = Math.max(knabsack(n - 1, k - w[n - 1]) + v[n - 1], knabsack(n - 1, k));
//        }
//        return dp[n][k];
//    }

    private static int buttomUpknabsack(int n, int k) {


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (w[i - 1] <=j) {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i - 1],  dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][k];

    }
}
