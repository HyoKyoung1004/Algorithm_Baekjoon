import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int n;
        long w;

        public Node(int n, long w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w,o.w);
        }
    }
    static int N, M, Start,End;
    static ArrayList<Node>[] graph;
    static long[] dist;
    static boolean[] visit;

    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine()); //정점 수
        M= Integer.parseInt(br.readLine()); //간선 수

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());
        Start = Integer.parseInt(st.nextToken());
        End = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        dist = new long[N+1];

        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
//        dist[Start]=0L;
        pq.add(new Node(Start,0));

        while(!pq.isEmpty()){

            Node now = pq.poll();
            if(visit[now.n]) continue;

            visit[now.n] =true;
            dist[now.n] = now.w;

            if(now.n == End)
                break;

            for(Node tmp : graph[now.n]){
                if(dist[tmp.n] > dist[now.n]+ tmp.w)
                    pq.add(new Node(tmp.n,dist[now.n]+ tmp.w ));
            }
        }

        System.out.println(dist[End]);

    }
}