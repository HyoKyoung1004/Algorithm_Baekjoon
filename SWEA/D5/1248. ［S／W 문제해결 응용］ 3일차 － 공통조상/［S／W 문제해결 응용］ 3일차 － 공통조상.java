import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static class Node{ //트리의 각 노드는 부모와 자식을 가지고 있음
        int parent;
        ArrayList<Integer> child;
    }

    static int N, M, A, B; //노드 수, 간선 수,A,B
    static Node[] nodes;
    static ArrayList<Integer> ancestorA,ancestorB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc=1;tc<=TC;tc++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            nodes = new Node[N + 1];
            for(int i=1;i<=N;i++){
                nodes[i] = new Node();
                nodes[i].child = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++){
                int p = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                nodes[p].child.add(e);
                nodes[e].parent = p;
            }


            //조상 찾아서 넣기
            ancestorA = new ArrayList<>();
            ancestorB = new ArrayList<>();
            traverse(A, ancestorA);
            traverse(B, ancestorB);

            //공통 조상 찾기,
            int lca = -1;
            for(int i=0;i<N;i++){
                //다르면 멈춰
                if(!ancestorA.get(i).equals(ancestorB.get(i))) break;
                lca = ancestorA.get(i);
            }

            int subTreeNum = dfs(lca);
            sb.append("#"+tc+" "+lca+" "+subTreeNum+"\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int n) {
        int res=1; //나 자신
        for(int tmp : nodes[n].child)
            res+= dfs(tmp);

        return res;
    }

    private static void traverse(int n, ArrayList<Integer> ancestor) {

        if(n!=1) //루트 노드가 아니면 부모 노드 존재
            traverse(nodes[n].parent, ancestor);
        ancestor.add(n);

    }
}
