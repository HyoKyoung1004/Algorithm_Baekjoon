import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int count=0;
        int start = 0;
        int end=num-1;

        while(start<end){
            if(arr[start]+arr[end]==target){
                count++;
                start++;
                end--;
            } else if (arr[start]+arr[end]<target) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count++);

    }
}
