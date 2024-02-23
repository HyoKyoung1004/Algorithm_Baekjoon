import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M,  N;
    static int[] arr;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        long sum=0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

         long reuslt = binarySearch(sum/M);
        System.out.println(reuslt);

    }

    private static long binarySearch(long end) {
        long start=1;
        long result =0;
        while(start<=end){

            long middle = (start+end)/2;

            if(possible(middle)){
                start = middle+1;
               result = middle;
            }else
                end = middle-1;
        }
        return result;

    }

    private static boolean possible(long middle) {
        int sum = 0;
        for(int i=0; i<N;i++){
            sum += arr[i] / middle;
        }
        if(sum>=M) return true;
        else return false;

    }

}
