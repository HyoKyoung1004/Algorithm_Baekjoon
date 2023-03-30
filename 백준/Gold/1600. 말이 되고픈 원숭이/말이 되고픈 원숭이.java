import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K,W,H;
	static int[][] map;
	static int[][] visit; //어떤 i,j에 스킬을 몇번쓰고 왔는지 k가지를 각각 true, false를 기록하기 위해
	
	static int[] di = {0,0,1,-1};
	static int[] dj= {1,-1,0,0};
	
	static int[] sdi = {-2,-1,1,2,2,1,-1,-2};
	static int[] sdj = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visit = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = Integer.MAX_VALUE;//이거보다 스클 적게쓴 원숭이네?

			}
		}
		System.out.println(bfs());
		
	}

	private static int bfs() {

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 0));
		visit[0][0]=0; //스킬 남은 횟수
		
		int time =0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++) {
				Point now = q.poll();
				
				//혹시 도착했니?
				if(now.i== H-1 && now.j==W-1) return time;
				
				//현재 now에서 걸아가는 원숭이 뿌리기
				for(int d=0;d<4;d++) {
					int nexti = now.i+di[d];
					int nextj = now.j+dj[d];
					if(nexti>=0 && nexti<H && nextj>=0 && nextj<W 
						&& map[nexti][nextj]==0	&& visit[nexti][nextj] >now.skill) { //now에서 걸아가는 원순이들이랑 now랑 skill횟수 같은 애들
						visit[nexti][nextj] = now.skill;
						q.add(new Point(nexti, nextj, now.skill));
						
					}
				}
				
				if(now.skill<K) { //시킬 횟수가 남아 있는지 확인해보기, 아래에서 skill+1해줄꺼니깐 현재는 k보다 작아야 함 
					for(int d=0;d<8;d++) {
						int nexti = now.i+sdi[d];
						int nextj = now.j+sdj[d];
						if(nexti>=0 && nexti<H && nextj>=0 && nextj<W 
							&& map[nexti][nextj]==0	&& visit[nexti][nextj]>now.skill +1 ) { //지금가는 원숭이가 스킬을 더 적게 쓰고 가는경우만 가
							visit[nexti][nextj]=now.skill +1;
							q.add(new Point(nexti, nextj, now.skill+1));
							
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
