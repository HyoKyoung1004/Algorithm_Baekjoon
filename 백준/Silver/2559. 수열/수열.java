import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		
		int lt = 0;
		int max = Integer.MIN_VALUE;
		
		int sum=0;
		for(int i=0;i<k-1;i++) {
			sum += arr[i];
		}
		
		for(int rt = k-1;rt<n;rt++,lt++) {
			sum+=arr[rt];
			if(sum>max) max =sum;
			sum-= arr[lt];
		}
		
		System.out.println(max);

	}

}