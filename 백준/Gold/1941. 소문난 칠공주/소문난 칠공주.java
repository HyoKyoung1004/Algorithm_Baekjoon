import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static char map[][];
	static boolean select[];
	static int ans, result;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][];
		select = new boolean[25];
		
		for(int i=0;i<5;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		comb(0,0);
		//System.out.println(result);
		System.out.println(ans);
		
		
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==7) {
			
			result++;//조합 개수확인,
			
			int scnt=0;
			boolean  isSeven =false;
			//1. 선택된 7개가 다 붙어 있는지 체크
			for(int i=0;i<25;i++) {
				if(select[i]) {
					isSeven=bfs(i);
					break;
				}
			}
			
			//2. S가 4개 이상인지 체크
			for(int i=0;i<25;i++) {
				if(select[i] && map[i/5][i%5]=='S') {
					scnt++;
				}
			}
			
			
			if(isSeven && scnt>=4) {
				ans++;
			}
			
			return;
		}
		

		if(idx==25) return;
		
		select[idx] = true;
		comb(idx+1,cnt+1);
		select[idx] = false;
		comb(idx+1,cnt);
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	private static boolean bfs(int start) {
		int si = start/5;
		int sj = start%5;
		
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[5][5];
		
		q.add(new Point(si,sj));
		visit[si][sj] = true;
		
		int cnt= 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			cnt++;
			if(cnt==7) return true;
			for(int d=0;d<4;d++) {
				int ni = now.x+dx[d];
				int nj = now.y+dy[d];
				if(ni>=0 && ni<5 && nj>=0 && nj<5 && 
						select[ni*5+nj] && !visit[ni][nj]) { //인접한 것이 우리가 선택한 것이니?
					visit[ni][nj]=true;
					q.add(new Point(ni,nj));
				}
			}
		}
		return false;
	}

}
