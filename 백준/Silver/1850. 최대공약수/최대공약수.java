import java.io.BufferedReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b= scan.nextLong();

        StringBuffer sb= new StringBuffer();
        long result = gcd(a,b);
        for(int i=0;i<result;i++){
            sb.append(1);
        }
        System.out.println(sb);
    }
    private static long gcd(long a, long b){
        //System.out.println(a+", "+b +", "+(a%b));
        if(a%b ==0) return b;
        else return gcd(b,a%b);
    }
}
