import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] bar;
	static StringBuilder sb = new StringBuilder();
	static long count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		if (n <= 20) {

			bar = new ArrayList[4];
			for (int i = 1; i <= 3; i++)
				bar[i] = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				bar[1].add(i);
			}

			Hanoi(n, 1, 3);
			System.out.println(count);
			System.out.println(sb);
			
		} else {
			BigInteger pow = new BigInteger("1");
			for (int i = 1; i <= n; i++) {
				pow = pow.multiply(new BigInteger("2"));
			}
			System.out.println(pow.subtract(new BigInteger("1")));

		}

	}

	private static void Hanoi(int n, int from, int to) {

		if (n == 1) {
			bar[to].add(bar[from].get(0));
			sb.append(from + " " + to + "\n");
			count++;
			return;

		}

		int tmp = 6 - (from + to);
		Hanoi(n - 1, from, 6 - (from + to));
		bar[to].add(bar[from].get(0));
		sb.append(from + " " + to + "\n");
		Hanoi(n - 1, tmp, to);
		count++;

	}

}