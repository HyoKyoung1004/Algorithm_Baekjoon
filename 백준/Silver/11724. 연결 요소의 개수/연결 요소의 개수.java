import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean visit[];
    static ArrayList<Integer>[] al;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        al = new ArrayList[n+1];
        visit = new boolean[n+1];

        for(int i=1;i<=n;i++){
            al[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            al[s].add(e);
            al[e].add(s);
        }


        int count=0;
        for(int i=1;i<=n;i++){
            if(!visit[i]){
                DFS(i);
                count++;
            }
        }

        System.out.println(count);

    }

    private static void DFS(int i) {

        visit[i]= true;

        for(int k : al[i]){
            if(!visit[k]){
                DFS(k);
            }
        }


    }
}
