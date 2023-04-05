import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x,y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}

	static int R,C, finalX, finalY;
	static char[][] arr;
	static int[][] visit, visitWater;
	static Queue<Point> queue = new LinkedList<Point>();
	static Queue<Point> waterQ = new LinkedList<Point>();
	//static PriorityQueue<Point> q= new PriorityQueue<>();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][];
		visit = new int[R][C];
		visitWater = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				visitWater[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=0;i<R;i++) {
			arr[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(arr[i][j] =='S') { 
					queue.add(new Point(i, j));
					visit[i][j]=1;
				}else if(arr[i][j] =='*') { 
					waterQ.add(new Point(i, j));
					visitWater[i][j]=1;
					}
				else if(arr[i][j] =='D') {
					finalX = i;
					finalY=j;
					visitWater[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		
		//물을 먼저 돌리자,,,, 
		bfsWater(waterQ);
		
		String result =bfs(queue);
		
		System.out.println(result);
		
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	private static void bfsWater(Queue<Point> q) {
		
		while(!q.isEmpty()) {
			int size = q.size();
			//System.out.println(q);
			for(int i=0;i<size;i++) {
				
				Point now = q.poll();
				
				for(int d=0;d<4;d++) {
					int nextX = now.x+dx[d];
					int nextY = now.y+dy[d];
					if(nextX>=0 && nextX<R && nextY>=0 && nextY<C &&(arr[nextX][nextY]=='.' || arr[nextX][nextY]=='S')&& visitWater[nextX][nextY] > visitWater[now.x][now.y]+1 ) {
						visitWater[nextX][nextY]= visitWater[now.x][now.y]+1;
						q.add(new Point(nextX, nextY));
					}
				}
				
			}
		}
		
	}

	private static String bfs(Queue<Point> q) {
		
		while(!q.isEmpty()) {
			int size = q.size();
			//System.out.println(q);

			for(int i=0;i<size;i++) {
				
				Point now = q.poll();
				
				if(now.x == finalX && now.y== finalY) {
					return (visit[now.x][now.y]-1)+"";
				}
				
				for(int d=0;d<4;d++) {
					int nextX = now.x+dx[d];
					int nextY = now.y+dy[d];
					
					if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && (arr[nextX][nextY]=='.'|| arr[nextX][nextY]=='D') && visit[nextX][nextY]==0 
							&& visit[now.x][now.y]+1<visitWater[nextX][nextY] ) {
							visit[nextX][nextY] = visit[now.x][now.y]+1;
							q.add(new Point(nextX, nextY));		
					}
				}
			}
		}
		
		return "KAKTUS";
		
	}

}
