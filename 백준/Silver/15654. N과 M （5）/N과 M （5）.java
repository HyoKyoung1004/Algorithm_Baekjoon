import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[] arr,result;
	static boolean[] isSelected;
	static StringBuilder sb= new StringBuilder();

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M= scan.nextInt();
		
		
		arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		result = new int[M];
		isSelected = new boolean[N];
		perm(0);
		System.out.println(sb);
		
		
	}

	private static void perm(int cnt) {
		
		if(cnt ==M) {
			
			for(int i=0;i<M;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			result[cnt]=arr[i];
			perm(cnt+1);
			isSelected[i] = false;

		}
	}

}