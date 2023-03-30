import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] arr;
	static int[][] visit;
	static ArrayList<Point> points;
	static int size;
	static int[] result;
	static int minTime = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[N][N];
		points = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) points.add(new Point(i,j));
			}
		}
		
		size = points.size();
		result = new int[M];
		comb(0,0);
		if(minTime==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minTime);
		
	}

	private static void comb(int start, int cnt) {
		if(cnt == M) {
			//System.out.println(Arrays.toString(result));
			int time = bfs();
			if(time==-1) return;
			if(time<minTime) minTime=time;
			return;
		}
		
		for(int i=start;i<size;i++) {
			result[cnt] = i;
			comb(i+1,cnt+1);
		}
		
	}
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	private static int bfs() {

		Queue<Point> q = new LinkedList<Point>();
		visit = new int[N][N];
		for(int i=0;i<M;i++) {
			q.add(points.get(result[i]));
			visit[points.get(result[i]).x][points.get(result[i]).y]=1;
		}
		
		int count=0;
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int s=0;s<size;s++) {
				Point now =q.poll();
				
				for(int d=0;d<4;d++) {
					int nextX=now.x+dx[d];
					int nextY =now.y+dy[d];
					
					if(nextX>=0 && nextX<N && nextY>=0 && nextY<N 
							&& visit[nextX][nextY]==0 && arr[nextX][nextY]!=1) {
						visit[nextX][nextY] = visit[now.x][now.y]+1;
						q.add(new Point(nextX,nextY));
					}
				}
				
			}
			count++;
		}
		
		//공백이 있는 지 확인 
		if(empty()) return -1;
		
		return count-1;
	}
	
	
	private static boolean empty() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]!=1 && visit[i][j]==0 ) return true;
			}
		}
		return false;
	}

	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1) System.out.print("- ");
				else System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
