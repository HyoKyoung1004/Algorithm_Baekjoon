import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb=new StringBuffer();
		
		int tc = Integer.parseInt(br.readLine());
		
		
		long[] arr = new long[101];
		arr[1]=1;
		arr[2]=1;
		arr[3]=1;
		
		for(int i=4;i<=100;i++) {
			arr[i] = arr[i-3]+arr[i-2];
		}
		
		
		
		for(int t=0;t<tc;t++) {
			
			int n= Integer.parseInt(br.readLine());
			sb.append(arr[n]+"\n");
			
		}
		//System.out.println(arr[100]);
		
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}

}
