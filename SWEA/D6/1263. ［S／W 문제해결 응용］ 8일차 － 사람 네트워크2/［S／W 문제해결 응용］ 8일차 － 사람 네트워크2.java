import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static final int INF = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hyo kyoung\\IdeaProjects\\hello\\src\\SSAFY\\day0403\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuffer sb= new StringBuffer();

		for(int tc=0;tc<TC;tc++) {
			
			int min = Integer.MAX_VALUE;
			

				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int[][] arr = new int[N][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
						if(arr[i][j]==0 && i!=j) arr[i][j] = INF;
					}
				}
				
				for(int k=0;k<N;k++) {
					for(int i=0;i<N;i++) {
							if(k==i) continue; 
						for(int j=0;j<N;j++) {
							if(k==j || i==j) continue;
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
						}
					}
				}
					
				for(int i=0;i<N;i++) {
					int sum = 0;
					for(int j=0;j<N;j++) {
						sum+=arr[i][j];
					}
					min = Math.min(sum, min);
				}
			//System.out.println("#"+(tc+1)+" "+min);
			sb.append("#"+(tc+1)+" "+min+"\n");
		}
		System.out.println(sb);
	}

}