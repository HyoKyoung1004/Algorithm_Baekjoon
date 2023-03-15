import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] bar;
	static StringBuilder sb = new StringBuilder();
	static long count = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		bar = new ArrayList[4];
		for (int i = 1; i <= 3; i++)
			bar[i] = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			bar[1].add(i);
		}

		Hanoi(n, 1, 3);
		System.out.println(count);
		System.out.println(sb);
	}

	private static void Hanoi(int n, int from, int to) {


		int tmp = 6 - (from + to);
		
		if(n>1) Hanoi(n - 1, from, tmp);
		
		bar[to].add(bar[from].get(0));		
		sb.append(from + " " + to + "\n");

		if(n>1 )Hanoi(n - 1, tmp, to);
		
		count++;

	}

}