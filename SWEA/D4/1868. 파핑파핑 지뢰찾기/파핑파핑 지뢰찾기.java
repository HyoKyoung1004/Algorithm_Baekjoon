import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int N, ans;
    static char[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            arr = new char[N][];

            for(int i=0;i<N;i++){
                arr[i] = br.readLine().toCharArray();
            }
            visit = new boolean[N][N];

            ans=0;
            search();
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.println(sb);

    }

    private static void search() {

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='.' &&!visit[i][j] && zero(i,j)){
                    ans++;
                    bfs(i,j);
                }
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]=='.' &&!visit[i][j]){
                    ans++;
                }
            }
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visit[i][j] = true;

        while(!q.isEmpty()){

            int[] now = q.poll();
            for(int k=now[0]-1;k<=now[0]+1;k++){
                for(int l=now[1]-1;l<=now[1]+1;l++){
                    if(l<0 || l>=N || k<0 || k>=N || visit[k][l]) continue;
                    visit[k][l]=true;
                    if(zero(k,l))
                        q.add(new int[]{k,l});
                }
            }
        }
    }

    private static boolean zero(int i, int j) {

        for(int k=i-1;k<=i+1;k++){
            for(int l=j-1;l<=j+1;l++){
                if(l<0 || l>=N || k<0 || k>=N ) continue;
                if(arr[k][l]!='.') return false;
            }
        }
        return true;
    }
}
