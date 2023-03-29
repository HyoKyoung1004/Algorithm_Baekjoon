import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i=1;i<=K;i++) {
			
			int min =  Integer.MAX_VALUE;
				for(int j=0;j<N;j++) {
					if(arr[j] <=i && dp[i-arr[j]] != Integer.MAX_VALUE  ) {
					int tmp = dp[i-arr[j]]+1;
					min = Math.min(min, tmp);
				}
			}
			if(min != Integer.MAX_VALUE )
				dp[i] =min;
		}
		//System.out.println(Arrays.toString(dp));
		
		if(dp[K]==0 || dp[K]== Integer.MAX_VALUE ) System.out.println(-1);
		else System.out.println(dp[K]);
		
	}

}
