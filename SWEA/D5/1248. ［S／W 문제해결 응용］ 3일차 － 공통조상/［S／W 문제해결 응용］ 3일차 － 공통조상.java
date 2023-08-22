import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static ArrayList<Integer>[] graph;
    static int[] parent;
    static int V, E, S1, S2, subTreeSize;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int tc=1;tc<=TC;tc++){
            subTreeSize=0;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            S1 = Integer.parseInt(st.nextToken());
            S2 = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for(int i=1;i<=V;i++){
                graph[i] = new ArrayList<Integer>();
            }
            parent = new int[V+1];

            st  = new StringTokenizer(br.readLine());
            for(int i=0;i<E;i++){
                int s =  Integer.parseInt(st.nextToken());
                int e =  Integer.parseInt(st.nextToken());
                graph[s].add(e);
                parent[e]=s;
            }
            //공통 부모 찾기
            int commonParent=1;
            Set<Integer> set = new HashSet<>();
            int nowParent=S1;
            while(nowParent!=0){
                set.add(nowParent);
                nowParent = parent[nowParent];
            }
            nowParent=S2;
            while(nowParent!=0){
                if(set.contains(nowParent)){
                    commonParent = nowParent;
                    break;
                }
                nowParent = parent[nowParent];
            }

            //서브트리 크기 구하기
            bfs(commonParent);
            sb.append("#"+tc+" "+commonParent+" "+subTreeSize+"\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int n) {
        subTreeSize++;
        for(int temp : graph[n]){
                bfs(temp);
        }
    }

}