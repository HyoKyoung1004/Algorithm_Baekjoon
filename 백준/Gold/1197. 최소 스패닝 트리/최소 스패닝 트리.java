import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int to,from, w;

		public Edge(int to, int from, int w) {
			super();
			this.to = to;
			this.from = from;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(w, o.w);
		}
		
	}
	
	static int V,E;
	static Edge[] edgeList;
	static int[] disjoint;

	public static void main(String[] args) throws Exception{

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edgeList);
		
		makeSet();
		
		int count=0,result=0;
		for(Edge edge : edgeList) {
			if(union(edge.to, edge.from)) {
				result += edge.w;
				count++;
				if(count ==V-1) break;
			}
		}
		
		if(count == V-1) System.out.println(result);
		else System.out.println(-1);
	}

	private static void makeSet() {
	
		disjoint = new int[V+1];
		
		for(int i=1;i<=V;i++) {
			disjoint[i] = i;
		}
	}
	private static int find(int a) {
		if(a== disjoint[a]) return a;
		return disjoint[a] = find(disjoint[a]);
	}
	
	private static boolean union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		disjoint[bRoot] = aRoot;
		return true;
	}
}