import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,ans=0;
	static int[][] map;
	static int right=0, down=1, cross=2;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		//dfs(0,1,0);
		if(map[N-1][N-1]!=1) {
			bfs();
			//dfs(0,1,0);
		}
		System.out.println(ans);
	}
	
	
	
	//현재 놓여 있는 칸에서 현재 파이트 방향을 바탕으로 갈 수 있는 옆칸 찾아서 파이프 보내기
	static void dfs(int nowi, int nowj, int dir) {
		
		if(nowi==N-1 && nowj==N-1) {
			ans++;
			return;
		}
		
		//현재 오른쪽으로 보내야 하는 경우
		//현재 방향이 down아니고 장애물이 없으면
		if(dir!= down && nowj+1<N && map[nowi][nowj+1]==0) {
			dfs(nowi, nowj+1, right);
		}
		
		//아래로
		if(dir!= right && nowi+1<N && map[nowi+1][nowj]==0) {
			dfs(nowi+1, nowj, down);
		}
		
		if(nowi+1<N && nowj+1 <N &&map[nowi+1][nowj]==0 && map[nowi][nowj+1]==0 && map[nowi+1][nowj+1]==0 ) {
			dfs(nowi+1, nowj+1,cross);
		}
		
	}
	static void bfs() {
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0,1,right));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.i==N-1 && now.j==N-1) {
				ans++;
			}
			if(now.dir!= down && now.j+1<N && map[now.i][now.j+1]==0) {
				q.add(new Point(now.i, now.j+1, right));
			}
			
			//아래로
			if(now.dir!= right && now.i+1<N && map[now.i+1][now.j]==0) {
				q.add(new Point(now.i+1, now.j, down));
			}
			
			if(now.i+1<N && now.j+1 <N &&map[now.i+1][now.j]==0 && map[now.i][now.j+1]==0 && map[now.i+1][now.j+1]==0 ) {
				q.add(new Point(now.i+1, now.j+1,cross));
			}
		}
	}


}

class Point{
	int i, j,dir;

	public Point(int i, int j, int dir) {
		super();
		this.i = i;
		this.j = j;
		this.dir = dir;
	}
	
}
