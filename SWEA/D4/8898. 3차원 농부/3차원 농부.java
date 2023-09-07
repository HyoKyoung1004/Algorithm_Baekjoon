import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N,M;
    static long c1, c2;

    static long[] z1, z2;

    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int TC =  Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb= new StringBuilder();

        for(int tc=1; tc<=TC;tc++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            c1 = Long.parseLong(st.nextToken());
            c2 = Long.parseLong(st.nextToken());

            z1 = new long[N];
            z2= new long[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                z1[i] =Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                z2[i] =Long.parseLong(st.nextToken());
            }

            Arrays.sort(z1);
            Arrays.sort(z2);

            long min = Long.MAX_VALUE;
            long count=0;
            for(int i=0;i<N;i++){
            //    System.out.println(i);

                //나랑 제일 가까운 왼쪽찾기
                long left =searchLeft(z1[i]);
                long dis1 = calDistance(z1[i], left);
                if(min>dis1){
                    min= dis1;
                    count=1;
                }else if(min==dis1) count++;
               // System.out.println(dis1);

                long right =searchRight(z1[i]);
                if(left == right) continue;
                long dis2 = calDistance(z1[i], right);
                if(min>dis2){
                    min= dis2;
                    count=1;
                }else if(min==dis2) count++;
              //  System.out.println(dis2);
             //   System.out.println("====");

            }

            sb.append("#"+tc+" "+min+" "+count+"\n");
        }
        System.out.print(sb);
    }

    private static long calDistance(long z1, long z2) {
        return Math.abs(c2-c1) + Math.abs(z1-z2);
    }

    private static long searchRight(long target) {
        //나보다 큰 것중에 제일 작은 것 찾기
        int start = 0;
        int end = M-1;
        long result = z2[M-1];

        while(start<=end){

            int mid = (start+end) / 2;

            if(z2[mid]>=target){
                end = mid-1;
                result = Math.min(result, z2[mid]);
            }else{
                start = mid+1;
            }

        }
        return result;
    }
    

    static long searchLeft(long target){

        //작은거 중에 큰거 찾기
        int start = 0;
        int end = M-1;
        long result = z2[0];

        while(start<=end){

            int mid = (start+end) / 2;

            if(z2[mid]<=target){
                start = mid+1;
                result = z2[mid];
            }else{
                end = mid-1;
            }
        }
        return result;
    }


}