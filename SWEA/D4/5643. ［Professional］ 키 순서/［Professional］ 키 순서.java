import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class  Solution{

	static int N,M, adj[][],cnt;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N=Integer.parseInt(in.readLine());
			M= Integer.parseInt(in.readLine());
			adj= new int[N+1][N+1];
			StringTokenizer st= null;
			int a, b;
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b]=1; //유향 
			}
			int ans=0;
			for(int i=1;i<=N;i++) {
				cnt=0;
				gtDFS(i,new boolean[N+1]);
				ltDFS(i,new boolean[N+1]);
				if(cnt==N-1)ans++;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	//자신보다 큰 정점을 탐색
	static void gtDFS(int cur, boolean[] visited) {
		visited[cur]=true;
		for(int i=1;i<=N;i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				cnt++;
				gtDFS(i,visited);
			}
		}
	}
	
	//cur정덤을 기준으로 자신보다 작은 정점 탐색
	static void ltDFS(int cur, boolean[] visited) {
		visited[cur]=true;
		for(int i=1;i<=N;i++) {
			if(adj[i][cur]==1 && !visited[i]) {
				cnt++;
				ltDFS(i,visited);
			}
		}
	}

}
