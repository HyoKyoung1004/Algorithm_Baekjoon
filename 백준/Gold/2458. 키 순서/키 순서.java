import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] tall, small ;
	static int N,M;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tall = new ArrayList[N+1];
		small = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			tall[i] = new ArrayList<Integer>();
			small[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tall[a].add(b);
			small[b].add(a);
		}
		
		int result=0;
		for(int i=1;i<=N;i++) {
			visit = new boolean[N+1];
			dfs(i,tall);
			dfs(i,small);
			
			boolean flag = true;
			for(int k=1;k<=N;k++) {
				if(!visit[k]) flag =false;
 			}
			if(flag) result++;
		}
		
		System.out.println(result);
		
		
		
	}
	private static void dfs(int i, ArrayList<Integer>[] al) {
		visit[i] = true;
		for(int tmp : al[i]) {
			if(!visit[tmp]) {
				dfs(tmp,al);
			}
		}
	}

}
