import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Node{
		int i,j, d; //시작 점의 위치  //시작점으로부터 오른쪽으로 : 가로 0, 아래로: 세로 1

		public Node(int i, int j, int d) { 
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node [i=" + i + ", j=" + j + ", d=" + d + "]";
		}
		
	}
	
	
	static int N;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static char[][] arr;
	static boolean visit[][][];
	static Node start, end;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력을 받기 위해 선언
		N = Integer.parseInt(br.readLine()); //배열 크기
		
		arr = new char[N][]; //배열 선언
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray(); //배열 입력 받음
		}
		
		
		
		//BBB와 EEE의 위치를 찾는다.
		//시작점의 위치와 방향을 Node클래스로 저장한다.
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//시작점 저장
				if(arr[i][j]=='B' && start==null) {
					if(i+2<N && arr[i+2][j]=='B') { //세로다
						start = new Node(i, j, 1);
					}
					
					if(j+2<N && arr[i][j+2]=='B') { //가로다
						start = new Node(i, j, 0);
					}
				}
				
				//도착점 저장
				if(arr[i][j]=='E' && end==null) {
					if(i+2<N && arr[i+2][j]=='E') { //세로다
						end = new Node(i, j, 1);
					}
					
					if(j+2<N && arr[i][j+2]=='E') { //가로다
						end = new Node(i, j, 0);
					}
				}
			}
		}
		
//		System.out.println(start);
//		System.out.println(end);

		visit = new boolean[N][N][2];//방향은 시작점에서 가로, 세로로 저장할 수 있으므로 3차원배열로 선언
		int result = bfs(); //최소 시간을 찾기 위해 bfs를 사용한다. 
		
		System.out.println(result);
		
	}

	
	//최소 시간을 찾기 위해 bfs를 사용한다. 
	private static int bfs() {
		
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		visit[start.i][start.j][start.d] = true; //시작점 방문 체크
		int result=0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0;s<size;s++ ) { //걸리는 시간을 찾기 위해 큐에서 사이즈만큼만 꺼낸다. 
				Node now = q.poll();
				//System.out.println(now);
				
				if(now.i == end.i && now.j== end.j && now.d == end.d) return result; //현재 점이 도착점과 같다면 걸리는 시간을 반환한다. 
				
				
				//4방 탐색을 통해 다음 점으로 이동가능한지 체크하고 가능하다면 큐에 넣는다. 
				for(int d=0;d<4;d++) {
					
					int nexti = now.i+dx[d]; 
					int nextj = now.j+dy[d];
					
					
					if(check(nexti,nextj,now.d)) {
						//일단, 내가 가려는 칸으로 갈 수 있는지 기둥이 있는지 업는지, 이미 방문한적이 있었는지 확인
						//기둥이 없으면 큐에 넣고, 방문체크, 
						visit[nexti][nextj][now.d]=true;
						q.add(new Node(nexti, nextj, now.d));
					}
				}
				
				//일단 네모칸 확인
				//가로이면, 상 하 열
				//세로이면 좌측 행 확인필요
				//괜찮으면 회전
				
				
				if(checkBlock(now.i,now.j,now.d)) {
					int i = now.i, j=now.j, d=now.d;
					//대각선이므로 옮긴 후에 시작점으로 변경하여 큐에 넣고 방문체크를 한다. 
					if(d==0) { //가로
						visit[i-1][j+1][1]=true;
						q.add(new Node(i-1, j+1,1));
					}else { //세로
						 visit[i+1][j-1][0]=true;
						 q.add(new Node(i+1, j-1,0));
					}
				}
				
				
			}
			result++;
		}
		
		return 0;
		
	}

	private static boolean checkBlock(int i, int j, int d) {
		
		//일단 회전이 가능한지 부터 체크
		if(d==0 ) { //현재 가로다
			if(i-1<0 || i+1>=N ) return false;
			
			//기둥이 존재하면 false
			for(int x = i-1; x<=i+1;x++) {
				for(int y = j;y<=j+2;y++) {
					if(arr[x][y]=='1') return false;
				}
			}
		}else {
			if(j-1<0 || j+1>=N) return false;//배열 범위 초과
			//기둥이 존재하면 false
			for(int x= i; x<=i+2;x++) {
				for(int y = j-1;y<=j+1;y++) {
					if(arr[x][y]=='1') return false;
				}
			}
		}
		
		//대각선으로 돌렸을 떄 이미 방문한 자리면 가지 않는다. 
		if(d==0 && 
				visit[i-1][j+1][1]) return false;
		
		if(d==1 && visit[i+1][j-1][0]) return false;
		
		return true;
		
	}

	private static boolean check(int i, int j, int d) {
		
		//배열 범위 초과
		if(i<0 || i>=N || j<0 || j>=N) return false;
		
		if(d==0 && j+2>=N) return false; //가로인 경우, 3칸이므로 범위 확인
		else if(d==1 && i+2>=N) return false; //세로인 경우, 범위 확인
		
		if(visit[i][j][d]) return false; //방문한적 있으면 
		
		//기둥이 있어서 이동 불가 
		if(d==0 && (arr[i][j]=='1' || arr[i][j+1]=='1' || arr[i][j+2]=='1')) return false;
		if(d==1 && (arr[i][j]=='1' || arr[i+1][j]=='1' || arr[i+2][j]=='1')) return false;

		return true;
		
	}
}
