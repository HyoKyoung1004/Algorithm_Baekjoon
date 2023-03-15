import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        dp= new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;

        System.out.println(fibo(n));
    }
    static private int fibo(int n){
        if(dp[n] !=-1 ) return dp[n];
        
        dp[n] = fibo(n-2)+fibo(n-1);
        return dp[n];

    }
}
