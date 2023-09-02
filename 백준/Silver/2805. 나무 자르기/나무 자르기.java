import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M =  Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long start=0, end=0;
        st = new StringTokenizer(br.readLine());
        long sum=0;
        for(int i=0;i<N;i++){

            arr[i] = Long.parseLong(st.nextToken());
            if(end < arr[i]) end = arr[i];
            sum+= arr[i];
        }

        long max = 0;
        while(start<=end){

            long mid = (start+end)/2;

            long value = getLength(mid, arr, N);

            if(value >= M) {
                start = mid+1;
                max = Math.max(max, mid);
            }else{
                end = mid-1;
            }
        }
        System.out.println(max);

    }

    private static long getLength(long mid, long[] arr, int n) {

        long total=0;

        for(int i=0;i<n;i++){
            if(arr[i] < mid) continue;
            total += arr[i] -mid;
        }
        return total;
    }


}