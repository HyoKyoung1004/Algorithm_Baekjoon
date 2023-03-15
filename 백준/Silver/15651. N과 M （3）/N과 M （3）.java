import java.util.Scanner;

public class Main {

	static int N,M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		 N = scan.nextInt();
		 M= scan.nextInt();
		
		result = new int[M];
		
		permu(0);
		System.out.println(sb);
	}
	//중복순열
	private static void permu(int cnt) {
		
		if(cnt ==M) {
			
			for(int i=0;i<M;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			
			return;
		}
		for(int i=1;i<=N;i++) {
			
			result[cnt] = i;
			permu(cnt+1);
		}
		
	}

}