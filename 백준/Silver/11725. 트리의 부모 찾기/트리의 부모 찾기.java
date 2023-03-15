import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	static ArrayList<Integer>[] tree;
	static boolean[]  visit;
	static int[] answer;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			tree[tmp1].add(tmp2);
			tree[tmp2].add(tmp1);
		}
		
		visit = new boolean[n+1];
		answer = new int[n+1];
		DFS(1);
		for(int i=2;i<=n;i++) {
			System.out.println(answer[i]);
		}
		
		
	}

	private static void DFS(int i) {
		// TODO Auto-generated method stub

		visit[i] = true;

		for (int k : tree[i]) {
			if (!visit[k]) {
				answer[k] = i;
				DFS(k);

			}

		}

	}

}
