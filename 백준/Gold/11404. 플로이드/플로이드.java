import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_000;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==j) arr[i][j] = 0;
				else arr[i][j] = INF;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int k=0;k<M;k++) { //직접 비용
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[s][e] = Math.min(arr[s][e], c);
		}
		
//		for(int i=1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
					if(k==i) continue; 
				for(int j=1;j<=N;j++) {
					if(k==j || i==j) continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
			
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(arr[i][j]>=INF)
					System.out.print(0+" ");
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
