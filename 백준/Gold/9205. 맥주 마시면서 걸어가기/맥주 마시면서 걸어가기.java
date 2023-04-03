import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
	}
	
	static int N;
	static int[][] arr;
	static Point[] po;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			
			int N =  Integer.parseInt(br.readLine());
			StringTokenizer st;
			po = new Point[N+2];
			arr = new int[N+2][N+2];
			
			for(int i=0;i<N+2;i++) {
				st = new StringTokenizer(br.readLine());
				po[i]= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0;i<N+2;i++) {
				for(int j=i+1;j<N+2;j++) {
					int dis = Math.abs(po[i].x-po[j].x)+Math.abs(po[i].y-po[j].y);
					if(dis>1000) {
						arr[i][j] = 32768*4;
						arr[j][i] = 32768*4;
					}
				}
			}
			//System.out.println(Arrays.deepToString(arr));
			
			for(int k=0;k<N+2;k++) {
				for(int i=0;i<N+2;i++) {
						if(k==i) continue; 
					for(int j=0;j<N+2;j++) {
						if(k==j || i==j) continue;
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
			
			//System.out.println(Arrays.deepToString(arr));

			if(arr[0][N+1]==0) System.out.println("happy");
			else System.out.println("sad");
			

		}
		
	}


}
