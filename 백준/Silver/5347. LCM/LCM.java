import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        for(int i=0;i<n;i++){

            int a = scan.nextInt();
            int b= scan.nextInt();

            int GCD = gcd(a,b);
            long tmp = (long)a*(long)b;
            System.out.println(tmp/GCD);



        }
    }
    static int gcd(int a, int b){

        if(b == 0 ) return a;
        return gcd(b, a%b);

    }

}