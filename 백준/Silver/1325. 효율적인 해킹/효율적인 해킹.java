import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] al;
    static int[] result;
    static boolean[] visit;
    static int max=0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        al= new ArrayList[n+1];
        result = new int[n+1];

        for(int i=1;i<=n;i++){
            al[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            al[s].add(e);
        }

        for(int i=1;i<=n;i++){
            visit = new boolean[n+1];
            BFS(i);
        }

        for(int i=1;i<=n;i++){
            if(result[i]>max)
                max=result[i];
        }

        for(int i=1;i<=n;i++){
            if(max == result[i])
                System.out.print(i+" ");
        }
    }

    private static void BFS(int i) {
        Queue<Integer> q= new LinkedList<>();
        q.offer(i);
        visit[i]=true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int k: al[tmp]){
                if(!visit[k]){
                    result[k]++;
                    q.offer(k);
                    visit[k]=true;
                }
            }
        }


    }
}
