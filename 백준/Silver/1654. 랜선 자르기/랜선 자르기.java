import java.util.Scanner;

public class Main {

   // static int count=0;
    static int[] arr;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
         n = scan.nextInt();
         m = scan.nextInt();

        long sum=0;
         arr= new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
            sum += arr[i];
        }

        long left =1;
        long right = (sum/m)+1;

        while(left+1 < right){

            long mid = (left+right)/2;
            int count = splitCount(mid);
            if(count >= m){
                left = mid;
            }else
                right = mid;

        }

        System.out.println(left);


    }

    static int splitCount(long mid){
        int count =0;
        for(int i=0;i<n;i++){
            count+= arr[i]/mid;
        }
        return count;
    }
}