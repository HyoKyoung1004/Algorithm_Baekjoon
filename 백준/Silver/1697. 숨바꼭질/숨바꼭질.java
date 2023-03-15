import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int K;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N= scan.nextInt();
        K= scan.nextInt();

        searchK(N,0);
        System.out.println(min);

    }

    private static void searchK(int start, int cnt){


        Queue<int[]> q= new LinkedList<>();
        boolean[] visit = new boolean[100000+1];

        q.offer(new int[]{start,cnt});
        visit[start]=true;

        while(!q.isEmpty()){

            int[] now = q.poll();
            int nowx = now[0];

            if(nowx==K){
                min = now[1];
                break;
            }

            if(nowx+1>=0 && nowx+1 <=100000 &&!visit[nowx+1] ){
                visit[nowx+1]  =true;
                q.offer(new int[]{nowx+1, now[1]+1});
            }

            if( nowx-1>=0 && nowx-1 <=100000 &&!visit[nowx-1] ){
                visit[nowx-1]  =true;
                q.offer(new int[]{nowx-1, now[1]+1});
                }

            if(nowx*2>=0 && nowx*2 <=100000 && !visit[nowx*2]){
                visit[nowx*2]  =true;
                q.offer(new int[]{nowx*2, now[1]+1});
            }
        }
    }
}