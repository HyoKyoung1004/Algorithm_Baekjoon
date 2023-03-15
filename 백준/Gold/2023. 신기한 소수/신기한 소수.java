import java.util.Scanner;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		//소수 발별 알고리즘
		prime(1,2);
		prime(1,3);
		prime(1,5);
		prime(1,7);
		
		System.out.println(sb);
	}

	private static void prime(int cnt, int pn ) {
		
		if(cnt == N) {
			if(isPrime(pn)) sb.append(pn+"\n");
			return;
		}

		
		for(int i=1 ;i<=9;i++) {
			if(i %2 == 1) {
				int number = pn*10+i;
				if(isPrime(number))
					prime(cnt+1, number);
			}
		}
		
	}

	private static boolean isPrime(int number) {
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i==0) return false;
		}
		return true;
	}

}