import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N =Integer.parseInt(st.nextToken()); //배열 크기
		int M= Integer.parseInt(st.nextToken()); //횟수
		
		int[][] arr= new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] sumArr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sumArr[i][j] = arr[i][j] + sumArr[i-1][j] + sumArr[i][j-1]- sumArr[i-1][j-1];
				//System.out.printf("[%d, %d] : %d + %d + %d - %d = %d \n", i,j, arr[i][j], sumArr[i-1][j],sumArr[i][j-1],sumArr[i-1][j-1],sumArr[i][j] );
			}
		}
		
		//System.out.println(Arrays.deepToString(sumArr));
		
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int j1 =Integer.parseInt(st.nextToken());
			
			int i2 =Integer.parseInt(st.nextToken());
			int j2 = Integer.parseInt(st.nextToken());
			
			int result = sumArr[i2][j2] - sumArr[i1-1][j2] - sumArr[i2][j1-1]+ sumArr[i1-1][j1-1];
			sb.append(result+"\n");
			
		}
		System.out.println(sb);
		
	}

}