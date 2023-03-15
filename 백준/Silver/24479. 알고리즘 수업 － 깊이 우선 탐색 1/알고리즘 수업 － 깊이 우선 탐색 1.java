import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visit;
    static int[] order;
    static int count;//몇번쨰 방문이지 count한다

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //정점의 수
        int m = Integer.parseInt(st.nextToken()); //간선의 수
        int r =Integer.parseInt(st.nextToken()); //시작정점


        A = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            //방향이 없다. => 양쪽에 넣어줘야 한다.
            A[s].add(e);
            A[e].add(s);
        }

        for(int i=1;i<=n;i++){
            Collections.sort(A[i]);
        }
        visit = new boolean[n+1];
        order = new int[n+1];
        //count =1;

        DFS(r);

        for(int i=1;i<=n;i++){
            System.out.println(order[i]);
        }
        

    }
    private static void DFS(int i) {
        //만약 방문한 노드라면,,,,
        if(visit[i]) return;

        visit[i] = true;
        count++;
        order[i]=count;

        //연결된 요소 가져오기
        for(int k : A[i]){
            if(!visit[k]){  //방문하지 않은 요소가 있으면,
                DFS(k);
            }
        } //연결된 요소를 다 방문했으면,,,

        // 더이상 연결 요소가 없다.

    }
}
