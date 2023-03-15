import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[] cards;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		N= scan.nextInt();
		M= scan.nextInt();
		
		cards = new int[N];
		result = new int[M];
		
		for(int i=0;i<N;i++) {
			cards[i] = scan.nextInt();
		}
		
		Arrays.sort(cards);
		
		comb(0,0);
		System.out.println(sb);
	}
	private static void comb(int cnt, int start) {
		
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(result[i]+" ");
			}			
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			
			result[cnt] = cards[i];
			comb(cnt+1,i);
		}
		
	}

}