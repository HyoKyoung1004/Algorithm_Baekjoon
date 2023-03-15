import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cars = br.readLine(); // 차량 번호판 입력
		char[] arr = cars.toCharArray();
	
		int total=1;
		int same=0;
		for(int i=0;i<arr.length;i++) {
			
			if(i>0 && arr[i-1] == arr[i] )
				same++;
			else if(i>0 && arr[i-1] != arr[i])
				same=0;
			
			if(arr[i] == 'c')
				total *= same==0 ? 26:25;
				//total *= 26-same;
			if(arr[i] == 'd')
				total *= same==0 ? 10:9;
				//total *= 10-same;

		}
		
		System.out.println(total);

	}

}