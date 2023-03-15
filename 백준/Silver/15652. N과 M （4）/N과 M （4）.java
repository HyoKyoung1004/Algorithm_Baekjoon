import java.util.Scanner;

public class Main {

	
	static int N,M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan =  new Scanner(System.in);
		N =scan.nextInt();
		M = scan.nextInt();
		
		result = new int[M];
		
		comb(0,1);
		
		System.out.println(sb);
		
		
	}

	private static void comb(int cnt, int start) {
		
		if(cnt ==M) {
			
			for(int i=0;i<M;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
			
		}
		
		for(int i=start;i<=N;i++) {
			result[cnt]=i;
			comb(cnt+1,i);
			
		}
		
	}

}