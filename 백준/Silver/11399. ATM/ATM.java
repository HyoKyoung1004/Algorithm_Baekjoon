import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long result=0;
        long[] hab = new long[n];
        for(int i=0;i<n;i++){
           if(i==0) hab[i] = arr[i];
           else hab[i] = hab[i-1]+arr[i];
           result+= hab[i];
        }

        System.out.println(result);

    }
}
