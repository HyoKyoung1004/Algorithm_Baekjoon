import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Vertex{
        double x, y;

        public Vertex(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int v1, v2;
        double value;

        public Edge(int v1, int v2, double value) {
            this.v1 = v1;
            this.v2 = v2;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(value, o.value);
        }
    }

    static int N;
    static Vertex[] V;
    static int[] union;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        V = new Vertex[N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            V[i] = new Vertex(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }

        ArrayList<Edge> elist = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                double distaance = Math.sqrt( (V[i].x-V[j].x)*(V[i].x-V[j].x) + (V[i].y-V[j].y)*(V[i].y-V[j].y));
                elist.add(new Edge(i, j, distaance));
            }
        }

        Collections.sort(elist);

        union = new int[N];
        for(int i=0;i<N;i++)
            union[i]=i;


        int eNum=0;
        double result=0;
        for(int i=0;i< elist.size();i++){
            Edge now = elist.get(i);
            if(isNotUnion(now.v1, now.v2)){
                eNum++;
                result += now.value;
            }
            if(eNum==N-1) break;
        }
        System.out.printf("%.2f\n", result);

    }

    static boolean isNotUnion(int a,int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        union[bRoot] = aRoot;
        return true;
    }

    static int findSet(int a){
        if( a == union[a]) return a;
        else return union[a] = findSet(union[a]);
    }
}
