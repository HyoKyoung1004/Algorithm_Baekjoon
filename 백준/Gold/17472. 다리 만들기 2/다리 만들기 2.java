import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }


    static int N, M, K;
    static int[][] arr;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    static int[][] adjArr;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] parent;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) arr[i][j] = -1;
            }
        }
        //--------------------input end ----------------------------------
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1) {
                    bfs(i, j, count);
                    count++;
                }
            }
        }
        K = count - 1; //섬의 개수 저장

        adjArr = new int[K + 1][K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    search(i, j);
                }
            }
        }

        makeEdgeList();
        //System.out.println(edgeList);
        Collections.sort(edgeList);

        makeSet();
        int V=0, result =0;
        for(Edge edge : edgeList){
            if(union(edge.from,edge.to)){
                result+= edge.weight;
                if(++V ==K-1) break;
            }
        }
        if(result==0 || V < K-1) System.out.println(-1);
        else System.out.println(result);


    }
    //서로서집합을 이용하여 MST 만들기 - 크루스칼 알고리즘
    private static void makeSet() {
        parent = new int[K+1];
        for(int i=1;i<=K;i++)
            parent[i]=i;
    }
    private static int findSet(int a){
        if(a == parent[a]) return a;
        return parent[a] = findSet(parent[a]);
    }
    private static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot =findSet(b);
        if(aRoot ==bRoot) return false;
        parent[bRoot] =aRoot;
        return true;
    }

    //인접 섬 탐색하기
    static void search(int nowi, int nowj) {

        int nowLand = arr[nowi][nowj];

        for (int d = 0; d < 4; d++) {

            int nextX = nowi + dx[d];
            int nextY = nowj + dy[d];

            while (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (arr[nextX][nextY] == 0) {
                    nextX = nextX + dx[d];
                    nextY = nextY + dy[d];
                    continue;
                } else if (arr[nextX][nextY] == nowLand) break;

                int w = -1;

                //세로 방향이라면
                if (nowj == nextY) w = Math.abs(nowi - nextX) - 1;
                //가로방향
                if (nowi == nextX) w = Math.abs(nowj - nextY) - 1;

                if (w >= 2) {
                    int to = arr[nextX][nextY];
                    if (adjArr[nowLand][to] == 0) adjArr[nowLand][to] = w;
                    else adjArr[nowLand][to] = Math.min(w, adjArr[nowLand][to]);
                }
                break;
            }

        }
    }
    //인접행렬을 간선리스트로 만들기
    static void makeEdgeList() {
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= K; j++) {
                if (i == j) continue;
                if (adjArr[i][j] > 0) {
                    edgeList.add(new Edge(i, j, adjArr[i][j]));
                }
            }
        }
    }

    //섬 번호븥이기
    private static void bfs(int i, int j, int count) {

        Queue<int[]> q = new LinkedList<>();
        arr[i][j] = count;
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {

            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextX = now[0] + dx[d];
                int nextY = now[1] + dy[d];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && arr[nextX][nextY] == -1) {

                    arr[nextX][nextY] = count;
                    q.offer(new int[]{nextX, nextY});
                }
            }

        }

    }
}