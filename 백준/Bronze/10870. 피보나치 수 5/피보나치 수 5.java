import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a = 0;
		int b = 1;

		if (n == 0)
			System.out.println(0);
		else {
			for (int i = 2; i <= n; i++) {
				int c = a + b;
				a = b;
				b = c;
			}

			System.out.println(b);
		}
	}

}