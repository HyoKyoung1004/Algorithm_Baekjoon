import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int n= scan.nextInt();
		int[] arr = new int[n+1];
		
		for(int i=1;i<=n;i++) 
			arr[i] =scan.nextInt();
		
		int person= scan.nextInt();
		for(int i=0;i<person;i++) {
			
			int gender = scan.nextInt();
			int target = scan.nextInt();
			
			if(gender ==1) {
				
				for(int k=target ;k<=n;k=k+target) {
					arr[k] = arr[k]==1 ?0 :1;
				}
				
				
			}else {
				
				arr[target] = arr[target]==1 ?0 :1;
				
				int k=1;
				while(target-k >0 && target+k<=n) {
					
					if(arr[target-k] != arr[target+k])
						break;
					
					arr[target+k]=arr[target-k] = arr[target-k]==1 ?0 :1;
					k++;
				}//대칭확인끝

			} //여자 끝

			
		}//사람 수 만큼 끝
		
		
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i]+" ");
			if(i % 20==0) 
				System.out.println();
		}
		
	}

}