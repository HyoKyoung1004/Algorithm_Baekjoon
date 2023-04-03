import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int N,M;
	static int[][] map;
	static boolean[][][] visit; 
	
	static int[] dx = {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] =tmp.charAt(j)-'0';

			}
		}
		System.out.println(bfs());
		
	}

	private static int bfs() {

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 0));
		visit[0][0][0]=true;
		
		int time =1;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				Point now = q.poll();
				
				if(now.i== N-1 && now.j==M-1) return time;
				
				for(int d=0;d<4;d++) {
					int nexti = now.i+dx[d];
					int nextj = now.j+dy[d];
					if(nexti>=0 && nexti<N && nextj>=0 && nextj<M
						&& map[nexti][nextj]==0	&& !visit[nexti][nextj][now.skill] ) { 
						visit[nexti][nextj][now.skill] = true;
						q.add(new Point(nexti, nextj, now.skill));
						
					}
					if(now.skill==0) { 
					if(nexti>=0 && nexti<N && nextj>=0 && nextj<M 
							&& map[nexti][nextj]==1	&& !visit[nexti][nextj][1] ) { 
							q.add(new Point(nexti, nextj,1));
							
						}
					}
				}
				
			}
			time++;
		}
		return -1;
	}
	
	
	static class Point{
		
		int i,j, skill;

		public Point(int i, int j, int skill) {
			super();
			this.i = i;
			this.j = j;
			this.skill = skill;
		}
	}
	
	

}
