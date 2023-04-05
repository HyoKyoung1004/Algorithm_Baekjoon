# [D4] [Professional] 키 순서 - 5643 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo) 

### 성능 요약

메모리: 94,292 KB, 시간: 1,063 ms, 코드길이: 1,645 Bytes



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do


### DFS를 사용한 방법
```java
package live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 키순서_DFS {

	static int N,M, adj[][],cnt;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N=Integer.parseInt(in.readLine());
			M= Integer.parseInt(in.readLine());
			adj= new int[N+1][N+1];
			StringTokenizer st= null;
			int a, b;
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b]=1; //유향 
			}
			int ans=0;
			for(int i=1;i<=N;i++) {
				cnt=0;
				gtDFS(i,new boolean[N+1]);
				ltDFS(i,new boolean[N+1]);
				if(cnt==N-1)ans++;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	//자신보다 큰 정점을 탐색
	static void gtDFS(int cur, boolean[] visited) {
		visited[cur]=true;
		for(int i=1;i<=N;i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				cnt++;
				gtDFS(i,visited);
			}
		}
	}
	
	//cur정덤을 기준으로 자신보다 작은 정점 탐색
	static void ltDFS(int cur, boolean[] visited) {
		visited[cur]=true;
		for(int i=1;i<=N;i++) {
			if(adj[i][cur]==1 && !visited[i]) {
				cnt++;
				ltDFS(i,visited);
			}
		}
	}

}
```

### DFS의 역인접행렬을 사용한 

```java
package live;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서_DFS_역인접행렬 {

	static int N,M, adj[][],radj[][],cnt;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N=Integer.parseInt(in.readLine());
			M= Integer.parseInt(in.readLine());
			adj= new int[N+1][N+1];
			StringTokenizer st= null;
			int a, b;
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				radj[b][a]=adj[a][b]=1; //유향 
			}
			
			int ans=0;
			for(int i=1;i<=N;i++) {
				cnt=0;
				dfs(i,adj,new boolean[N+1]);
				dfs(i,radj,new boolean[N+1]);
				if(cnt==N-1)ans++;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	//자신보다 큰 정점을 탐색
	static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur]=true;
		for(int i=1;i<=N;i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}
	}
}

```


### 플로이드 워셜을 사용한 방법

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 키순서_플로이드 {

	static int N,M, adj[][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N=Integer.parseInt(in.readLine());
			M= Integer.parseInt(in.readLine());
			adj= new int[N+1][N+1];
			StringTokenizer st= null;
			int a, b;
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(in.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b]=1; //유향 
			}
			int ans=0;

			for(int k=1;k<=N;k++) {//경유
				for(int i=1;i<=N;i++) { //출발(i학생)
					if(i==k || adj[i][k]==0) continue;//경유효과가 없음, i와kd와의 관계가 없어 경유 뷸가
					for(int j=0;j<=N;j++) { //도착(j학생)
						// i<k<j:학생 i보다 학생 k가 키가 끄코 학상 k보다 학생 j키가 크면 고로 학생 i보다 학생 j의 키다 크다.
						if(adj[i][j]==1) continue; //이미 i보다 j가 크다는 사실관계를 알면 패스, 0일때만 내려감
						//i와 k가 관계가 있으면 내려오니깐,  k와 j의 관계가 성릴합는 지 확인
						adj[i][j]=adj[i][k] & adj[k][j];
					}
				}
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					adj[i][0] +=adj[i][j]; //0행이 비어있으니깐 거기에다가 누적하자, 자신보다 키카 큰 학생 수 누적
					adj[0][j] += adj[i][j];//자신보다 키가 작은 학생 수 누적
				}
			}
			
			for(int i=1;i<=N;i++) {
				if(adj[i][0]+adj[0][i] ==N-1) ans++;
			}
			

			System.out.println("#"+tc+" "+ans);
		}
	}
}

```
