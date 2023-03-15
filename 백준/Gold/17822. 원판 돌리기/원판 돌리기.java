import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,T;
	static int[][] arr;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr= new int[N+1][M];
		
		for(int i=1;i<=N;i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<T;i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int d = Integer.parseInt(st.nextToken());
			 int k = Integer.parseInt(st.nextToken());
			 rotate(x,d,k);
			 adjNumber();
		}
		
		
		//원판의 합을 구하자
		int sum=0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);
		
		
	}

	//인접한 숫자들을 찾는다.
	private static void adjNumber() {
		boolean[][] adj = new boolean[N+1][M];
		boolean existAdj = false; //인접한 것이 존재한다. 
		
		//양옆이 같은 것을 찾는다. 
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M-1;j++) {
				if(arr[i][j]!=0 && arr[i][j] == arr[i][j+1]) {
					adj[i][j] = adj[i][j+1] = true;
					existAdj = true;
				}
			}
			//맨앞과 맨끝도 인점
			if(arr[i][0]!=0 && arr[i][0] == arr[i][M-1]) {
				adj[i][0] = adj[i][M-1] = true;
				existAdj = true;
			}
			
			
		}
		
		//위 아래가 같은 것을 찾는다
		for(int j=0;j<M;j++) {
			for(int i=1;i<=N-1;i++) {
				if(arr[i][j]!=0 && arr[i][j] == arr[i+1][j]) {
					adj[i][j] = adj[i+1][j] = true;
					existAdj = true;
				}
			}
			
		}
		
		if(existAdj) { //인접한 것이 있다 
			for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					if(adj[i][j]) { //인접한 수가 존재한다.
						arr[i][j] = 0;
					}
				}
			}
		}else { //인접한 것이 없다.
			int sum = 0;
			int count=0;
			for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]!=0) { 
						sum += arr[i][j];
						count++;
					}
				}
			}
			
			double avg = sum/(double)count;
			for(int i=1;i<=N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]!=0) {
						if(arr[i][j]>avg) arr[i][j]--;
						else if(arr[i][j]<avg)arr[i][j]++;
					}
				}
			}
			
		}
	}

	private static void rotate(int x, int d, int k) {

		for(int i=x;i<=N;i=i+x) {//x의 배수만큼 돌리기
			
			for(int j=0;j<k;j++) { //k칸 회전
				if(d==0) right(i);
				else left(i);
			}
		}
	}

	//반시계 방향 회전
	private static void left(int x) {
		int tmp = arr[x][0];
		for(int i=0;i<M-1;i++) {
			arr[x][i] = arr[x][i+1];
		}
		arr[x][M-1] = tmp;
	}

	//시계방향 회전
	private static void right(int x) {
		int tmp = arr[x][M-1];
		for(int i=M-1;i>=1;i--) {
			arr[x][i] = arr[x][i-1];
		}
		arr[x][0] = tmp;
	}
	
	
//	static void printArr() {
//		for(int i=1;i<=N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}