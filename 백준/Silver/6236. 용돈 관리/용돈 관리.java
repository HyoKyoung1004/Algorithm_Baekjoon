import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int[] arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		 n = scan.nextInt();
		 m = scan.nextInt();
		arr = new int[n];
		
		 
		int sum =0;  
		int max = 0;
		for(int i=0;i<n;i++) {
			arr[i] = scan.nextInt();
			sum+= arr[i];
			if(arr[i]>max ) max =arr[i];
		}
		
		//int left = max;
		int left = 0;
		int right = sum ;
		int mid=0;
		
		while(left < right) {
			
			mid = (left+right)/2;
			
			if(possible(mid)) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		System.out.println(right);
		
		
	}
	
	static boolean possible(int num) {
		
		int count = 1;
		long money = num;
		
		for(int i=0 ; i<n;i++) {
			if(arr[i] <= money)
				money -= arr[i];
			else {
				
				money =num;
				count++;
				money -= arr[i];
				if(money<0) return false;
				
			}
		}
		
		
	//	System.out.println(num+" "+count);
		if(count <= m) return true;
		
		return false;
		
	}

}