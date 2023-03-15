import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visit;
    static boolean arrival;

    public static void main(String[] args) throws  Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m =  Integer.parseInt(st.nextToken());  //엣지 개수

        A = new ArrayList[n];
        visit = new boolean[n];
        arrival=false;

        //ArryaList[]배열 초기화
        for(int i=0;i<n;i++){
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


        for(int i=0;i<n;i++){
            DFS(i,1); //깊이가 1
            if(arrival){
                break;
            }
        }

        if(arrival) System.out.println("1");
        else System.out.println("0");

    }

    private static void DFS(int i, int depth) {
        if(depth==5 || arrival){
            arrival =true;
            return;
        }
        visit[i] =true;
        for(int k : A[i]){
            if(!visit[k]){
                DFS(k,depth+1);
            }
        }
        visit[i] =false;
    }

}
