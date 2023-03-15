import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visit;
   // static StringBuffer sb;
    static int count;
    static int[] order;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m =  Integer.parseInt(st.nextToken());  //엣지 개수
        int v =  Integer.parseInt(st.nextToken());  //탐색을 시작할 노드, 시작점


        A = new ArrayList[n+1];
        visit = new boolean[n+1];

        //ArryaList[]배열 초기화
        for(int i=1;i<=n;i++){
            A[i] = new ArrayList<Integer>();
        }

        //엣지 갯수만큼 가져와서 인접리스트를 만들자
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //start 노드
            int e =  Integer.parseInt(st.nextToken());  //end 노드

            A[s].add(e);
            A[e].add(s);
        }

        //내림차순
        for(int i=1;i<=n;i++){
            Collections.sort(A[i]);
        }

        //sb= new StringBuffer();
        visit = new boolean[n+1];
        count=0;
        order= new int[n+1];


        BFS(v);

        for(int i=1;i<=n;i++){
            System.out.println(order[i]);
        }

        //System.out.println(sb);


    }

    private static void BFS(int v){


        if(visit[v]) return;

        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v]=true;
        order[v]=++count;


        while(!q.isEmpty()){
            int i= q.poll();
            for(int k : A[i]){
                if(!visit[k]){
                    visit[k]=true;
                    q.add(k);
                    order[k]=++count;
                }
            }

        }


    }
}
