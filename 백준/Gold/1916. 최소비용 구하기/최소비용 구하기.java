import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge>{
		int v;
		long w;

		public Edge(int v, long w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(w, o.w);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] adjList = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++){
			adjList[i] = new ArrayList<Edge>();
		}
		
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[a].add(new Edge(b, w));
		}
		
		st= new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		final int INF = Integer.MAX_VALUE;
		long[] D = new long[N+1];
		Arrays.fill(D, INF);
		D[start]=0;
		boolean[] visit = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visit[now.v]) continue;
			visit[now.v] =true;
			
			for(Edge e: adjList[now.v]) {
				if(!visit[e.v] && D[e.v]> now.w+e.w) {
					D[e.v]= now.w+e.w;
					pq.add(new Edge(e.v, D[e.v]));
				}
			}
		}
		System.out.println(D[end]);
		
			
	}
}
