import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++)
            arr[i] = scan.nextInt();

        for(int i=1;i<=n;i++){

            if(i<3)
                dp[i] = dp[i-1]+arr[i];

            else {

                int oneStep = dp[i-3] +arr[i-1]+arr[i];
                int twoStep = dp[i-2]+arr[i];

                dp[i] = Math.max(oneStep,twoStep);
            }
        }
        System.out.println(dp[n]);

    }
}