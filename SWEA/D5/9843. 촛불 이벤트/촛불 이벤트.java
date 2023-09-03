import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC =Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int tc=1;tc<=TC;tc++){

            long N = Long.parseLong(br.readLine());
            long result = searchK(N);
            //System.out.println(result);

            if( N == (result*(result+1)/2))
                sb.append("#"+tc+" "+result+"\n");
            else
                sb.append("#"+tc+" "+-1+"\n");

        }
        System.out.print(sb);


    }

    private static long searchK(long n) {

        long start =1;
        long end = 10000000000L;
        long max = 0;

        while(start <= end){

            long mid = (start+end)/2;
            long value = mid*(mid+1)/2;
            if(n >= value){ //만들 수 있어요 더 큰것을 찾아보고 싶어요
                start = mid+1;
                max = Math.max(max, mid);
            }else{
                end = mid-1;
            }
        }
        return max;
    }


}
