import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge>{

        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight,o.weight);
        }
    }


    static int V,E; // 정점의 수, 간선의 수
    static Edge[] edgeList;
    static int[] disjoint;

    //서로서 집합 만들기
    static void makeSet(){
        disjoint = new int[V+1];// 1부터 시작

        for(int i=1;i<=V;i++){
            disjoint[i]=i;
        }
    }

    static int findSet(int a){

        if(a == disjoint[a]) return a;

        return disjoint[a] =  findSet(disjoint[a]);
    }

    static boolean union(int a, int b){

        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        disjoint[bRoot] =aRoot;
        return true;
    }



    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

         V = Integer.parseInt(br.readLine());
         E = Integer.parseInt(br.readLine());
        edgeList = new Edge[E];

        makeSet();

        StringTokenizer st ;
        for(int i=0;i<E;i++){
            st= new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) );
        }
        Arrays.sort(edgeList);

        int result=0, count=0;

        for(Edge edge : edgeList){

            if(union(edge.from, edge.to)){
                result+= edge.weight;
                if(++count == V-1)
                    break;
            }
        }

        System.out.println(result);

    }
}