import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int i, j;
		long s;
		public Edge(int i, int j, long s) {
			super();
			this.i = i;
			this.j = j;
			this.s = s;
		}
		
		@Override
		public String toString() {
			return "Edge [i=" + i + ", j=" + j + ", s=" + s + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(s, o.s);
		}
	}
	
	static int N;
	static int[][] arr;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for(int t=1;t<=TC;t++) {
			
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visit = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j] = str.charAt(j)-'0';
				}
			}
			
			long result = serachMinHour();
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
		
		
	}

	static int[] dx = {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	private static long serachMinHour() {

		long result=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(visit[now.i][now.j]) continue;
			visit[now.i][now.j] =true;

			if(now.i==N-1 && now.j==N-1) 
				return now.s;
			
			
			for(int d=0;d<4;d++) {
				int nextX = now.i+dx[d];
				int nextY = now.j+dy[d];
				
				if(nextX<0 || nextX>=N || nextY<0 || nextY>=N || visit[nextX][nextY]) continue;
				
				pq.add(new Edge(nextX, nextY, now.s+arr[nextX][nextY]));
			}			
		}
		return result;
	}

}
