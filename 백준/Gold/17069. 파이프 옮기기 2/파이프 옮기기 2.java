import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static long ans=0;
	static int right=0, down=1, cross=2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		

		if(map[N-1][N-1]!=1) {
			dp();
		}
		System.out.println(ans);
	}
	
	
	static void dp() {
		long[][][] dp= new long[N][N][3];
		dp[0][1][right]=1;
		for(int i=0;i<N;i++) {
			for(int j=2;j<N;j++) {
				if(map[i][j]==0) { //일단 내가 빈칸니여야 나한테 오는 놈들을 세지
					if(j-1>=0) {//범위 체크 
						dp[i][j][right] += dp[i][j-1][right];
						dp[i][j][right] += dp[i][j-1][cross];

					}
					if(i-1>=0) {//범위 체크 , 위에서 나한테 들어옴
						dp[i][j][down] += dp[i-1][j][down];
						dp[i][j][down] += dp[i-1][j][cross];

					}
					if(i-1>=0 && j-1>=0 && map[i-1][j]==0 && map[i][j-1]==0 && map[i-1][j-1]==0 ) {//범위 체크 , 위에서 나한테 들어옴
						dp[i][j][cross] += dp[i-1][j-1][right];
						dp[i][j][cross] += dp[i-1][j-1][down];
						dp[i][j][cross] += dp[i-1][j-1][cross];
					}
					
				}
			}
		}
		ans=dp[N-1][N-1][right]+dp[N-1][N-1][down]+dp[N-1][N-1][cross];
	}

}


