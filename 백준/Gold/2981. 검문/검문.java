import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        int[] subArr = new int[n];

        for(int i=1;i<n;i++){
            subArr[i] = arr[i]-arr[i-1];
        }


        int gcd= subArr[1];
        for(int i=2;i<n;i++){
            gcd = GCD(subArr[i],gcd);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);



    }


    public static int GCD(int a, int b){
        if(b == 0)
            return a;
        return GCD(b, a % b);
    }


}