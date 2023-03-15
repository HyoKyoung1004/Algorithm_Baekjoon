import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int[] result;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			if(N==0) break;
			
			arr= new int[N];
			result = new int[6];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			combination(0,0);
			sb.append("\n");
			
			
			
		}
		
		System.out.println(sb);
	}

	private static void combination(int cnt, int start) {
		
		if(cnt == 6) {
			//System.out.println(Arrays.toString(result));
			for(int tmp: result)
				sb.append(tmp+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			result[cnt] = arr[i];
			combination(cnt+1,i+1);
		}
		
	}

}