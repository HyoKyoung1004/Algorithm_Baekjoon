import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] arr;
	static int count=0;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int max =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='L') {
					visit = new boolean[n][m];
					count=0;
					BFS(new int[] {i,j,0});
					//System.out.println(i+", "+j+" : "+count);
					max = Math.max(max, count);
				}
			}
		}
		System.out.println(max);
	}
	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };

	private static void BFS(int[] is) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>();
		q.offer(is);
		visit[is[0]][is[1]]=true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			//count++;
			int num = tmp[2];
			count = Math.max(num,count);
			for (int k = 0; k < 4; k++) {
				int x = tmp[0] + dx[k];
				int y = tmp[1] + dy[k];
				
				
				if (x >= 0 && x < n && y >= 0 && y < m && !visit[x][y] && arr[x][y] == 'L') {
					visit[x][y] = true;
					q.offer(new int[] { x, y,num+1 });
				}
			}
		}
	}

}