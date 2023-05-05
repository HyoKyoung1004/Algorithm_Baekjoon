import java.util.*;
class Solution {
    
    static class Edge implements Comparable<Edge>{
		int v,w;
		public Edge(int v,int w) {
			this.v=v;
			this.w=w;
		}
		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
	}
    
    final static int INF = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        	        
		
		ArrayList<Edge>[] adjList = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for(int i=0;i<fares.length;i++) {
			adjList[fares[i][0]].add(new Edge(fares[i][1], fares[i][2]));
			adjList[fares[i][1]].add(new Edge(fares[i][0], fares[i][2]));
		}
		
		int[] D = new int[n+1];
		Arrays.fill(D,Integer.MAX_VALUE);
		D[s]=0;
		boolean visit[] = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visit[now.v]) continue;
			visit[now.v]=true;
			
			for(Edge e: adjList[now.v]) {
				if(!visit[e.v] && D[e.v]> now.w+e.w) {
					D[e.v]= now.w+e.w;
					pq.add(new Edge(e.v, D[e.v]));
				}
			}
		}
		
		//System.out.println(Arrays.toString(D));
		
		int min = D[a]+D[b];
		for(int i=1;i<=n;i++) {
			if(i==s) continue;
			if(D[i]==INF) continue;
			int cost=searchmin(n,i,a,b,adjList,D[i]);
			if(min>cost)min=cost;
		}
		
		System.out.println(min);
		return min;
    }
    
    
    static int searchmin(int n, int s, int a, int b, ArrayList<Edge>[] adjList , int nowCost) {
		
		int[] D = new int[n+1];
		Arrays.fill(D,INF);
		D[s]=0;
		boolean visit[] = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(visit[now.v]) continue;
			visit[now.v]=true;
			
			if(visit[a] && visit[b]) break;
			for(Edge e: adjList[now.v]) {
				if(!visit[e.v] && D[e.v]> now.w+e.w) {
					D[e.v]= now.w+e.w;
					pq.add(new Edge(e.v, D[e.v]));
				}
			}
		}
		if(D[a]==INF || D[b]==INF) return INF;
		
		//System.out.println(s+": "+(nowCost+D[a]+D[b]));
		//System.out.println(Arrays.toString(D));
		return  nowCost+D[a]+D[b];
	}
}