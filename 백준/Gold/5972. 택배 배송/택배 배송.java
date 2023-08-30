import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int e,w;

        public Node( int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w -o.w;
        }
    }
    static int N,M;
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] total;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
             st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            int c =Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        visit = new boolean[N+1];
        total = new int[N+1];
        Arrays.fill(total, INF);

        // 제일 가까운 점이 필요하므로 시작점을 넣고 시작
       pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visit[node.e]){ //이미 방문했으면 넘어간다
                continue;
            }
            //최선으로 나 온 길
            total[node.e] = node.w;
            visit[node.e] =true;

            if(node.e==N) break;

            for(Node tmp : graph[node.e]){
                if(visit[tmp.e]) continue;
                if( total[tmp.e] > total[node.e]+ tmp.w )
                    pq.add(new Node(tmp.e, total[node.e] + tmp.w));
            }
        }
        System.out.println(total[N]);
    }
}