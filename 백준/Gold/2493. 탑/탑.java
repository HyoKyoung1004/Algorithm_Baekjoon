import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] result = new int[n+1];
		
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for (int i = 1; i <= n; i++) {
			int data =Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty())
				result[i]=0;
			else if(stack.peek()[0]> data) {
				result[i] = stack.peek()[1];
			}else if(stack.peek()[0]< data) {
				
				while(!stack.isEmpty() && stack.peek()[0]< data) {
					stack.pop();
				}
				
				if(stack.isEmpty())
					result[i]=0;
				else result[i] = stack.peek()[1];
			}
			
			stack.add(new int[] {data,i});
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			sb.append(result[i]+" ");
			
		}
		System.out.println(sb);
		//System.out.println(Arrays.toString(result));
		
		
		
	}

}