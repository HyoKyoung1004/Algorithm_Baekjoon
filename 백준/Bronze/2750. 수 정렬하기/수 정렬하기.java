import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i=0;i<num;i++){
            System.out.println(arr[i]);
        }




    }
}
