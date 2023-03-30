import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static int[][] arr;
	static boolean[][] visit;
	static boolean[][] side;
	static int lastSize,size;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr= new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 size = remainSize();
		int time=0;
		while( size !=0) {
			time++;
			lastSize =size;
			visit = new boolean[R][C];
			side = new boolean[R][C];
			bfs();
			modifyArr();
		}
		
		System.out.println(time);
		System.out.println(lastSize);
		
	}
	
	private static void modifyArr() {
		int count=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(side[i][j]) arr[i][j]=0;
				if(arr[i][j]==1) count++;
			}
		}
		size = count;
	}

	private static int remainSize() {
		int count=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]==1) count++;
			}
		}
		return count;
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0,0));
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			
			for(int d=0;d<4;d++) {
				int nextX = now.x+dx[d];
				int nextY = now.y+dy[d];
				
				if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && !visit[nextX][nextY]) {
					if(arr[nextX][nextY]==1) 
						side[nextX][nextY] = true;
					else 
						q.add(new Point(nextX, nextY));
					visit[nextX][nextY]=true;
				}
				
			}
			
		}
		
	}
	
	static void print() {
		for(int i=0;i<R;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}
