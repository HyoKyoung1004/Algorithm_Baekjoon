import java.util.Arrays;
import java.util.Scanner;


public class Main {

	static int n;
	static int m;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 - 조합
		Scanner scan = new Scanner(System.in);
		n =scan.nextInt();
		m= scan.nextInt();
		
		result = new int[m];
		combination(0,1); //0번째 자리부터 넣을 껀데, 1부터 숫자 시작
		System.out.println(sb);
	}
	
	
	private static void combination(int cnt, int start) {
		if(cnt==m) {
			for(int tmp: result)
				sb.append(tmp+" ");
			sb.append("\n");

			return;
		}
		
		for(int i=start;i<=n;i++) {
			result[cnt] = i;
			combination(cnt+1, i+1);
		}
		
	}

}