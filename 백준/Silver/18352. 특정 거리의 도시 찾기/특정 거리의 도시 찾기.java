import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] al;
    static int[] visit;

    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int k= Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());

        al = new ArrayList[n+1];
        visit = new int[n+1];

        for(int i=1;i<=n;i++){
            al[i] = new ArrayList<>();
            visit[i] =-1;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s= Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            al[s].add(e);
        }

        DFS(x,0);
        StringBuffer sb= new StringBuffer();
        for(int i=1;i<=n;i++){
            if(visit[i] ==k)
                sb.append(i+"\n");
        }

        if(sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);

    }

    private static void DFS(int i, int d) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = d;

        while (!q.isEmpty()){
            int tmp = q.poll();
            for(int k: al[tmp]){
                if(visit[k] == -1 ){
                    q.add(k);
                    visit[k] = visit[tmp]+1;
                }
            }
        }
    }
}
