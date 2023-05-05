import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int v, w;


		public Edge(int v, int w) {
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
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] adjList = new ArrayList[V+1];
		
		for(int i=1;i<=V;i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Edge(v, w));
		}//입력 끝
		
		
		final int INF = Integer.MAX_VALUE;

		int[] D = new int[V+1];
		Arrays.fill(D, INF);
		D[start]=0;
		boolean[] visit = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		
		
		int currnet, value;
		while(!pq.isEmpty()) {
			//System.out.println(pq);
			
			Edge now = pq.poll();
			if(visit[now.v]) continue;
			visit[now.v]=true;
			
			for(Edge e: adjList[now.v]) {
				
				if(!visit[e.v] && D[e.v] > now.w+e.w) {
					D[e.v] = now.w+e.w;
					pq.add(new Edge(e.v, D[e.v]));
				}
			}
		}
		
		for(int i=1;i<=V;i++) {
			System.out.println(D[i]==INF ?"INF":D[i]);
		}
	}

}
