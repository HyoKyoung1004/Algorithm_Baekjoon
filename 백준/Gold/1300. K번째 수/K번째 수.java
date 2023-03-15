import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();


        //이분탐색 할껀데
        //시작 1
        //끝점 k

        int start =1, end =k;
        int mid=0;

        while(start< end){

             mid = (start+end)/2;


             //mid값에서 최소 갯수 세야함
            long count=0;
            for(int i=1;i<=n;i++){
                count += Math.min(mid/i,n);
            }



            //count가 크다 mid값을 줄여야해
            if(count>=k) end =mid;
            else if(count<k) start=mid+1;
            
        }

        System.out.println(start);


    }
}