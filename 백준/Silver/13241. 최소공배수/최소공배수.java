import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		long A = scan.nextLong();
		long B = scan.nextLong();
		long result =gcd(A,B);
		
		System.out.println((A*B)/result);
	}

	private static long gcd(long a, long b) {
		// TODO Auto-generated method stub
		if(a%b==0) return b;
		return gcd(b, a%b);
	}

}
