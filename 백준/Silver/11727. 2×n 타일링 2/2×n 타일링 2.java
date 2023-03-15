import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp= new long[n];

        dp[0]=1;
        if(n>=2)
            dp[1] = 3;

        for(int i=2;i<n;i++){
            dp[i] = (dp[i-2]*2+dp[i-1])%10007 ;
        }

        System.out.println(dp[n-1]);

    }
}
