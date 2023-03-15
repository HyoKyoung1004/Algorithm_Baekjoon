import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		boolean[][] arr = new boolean[102][102]; //100*100의 사각형을 사용하고 가장 이 사각형을 둘러싼 바깥쪽 둘레를 사용하지 않기 위해 +2만큼 크게 잡음 

		for (int k = 0; k < N; k++) {

			//떨어진 좌료의 길이를 입력 받는다. 떨어진 거리가 곧 원점으러 부터 떨어진 거리라고 생각하여 최적화 함
			int x = scan.nextInt();
			int y = scan.nextInt(); 
			
			//떨어진 거리에서 +1좌표부터 사각형을 만든다. 
			for (int i = x+1; i < x +1+ 10; i++) { //시작좌표에서 10의 길이만틈 사각형을 true로 만던다. 
				for (int j = y+1; j < y+1 + 10; j++) {
					arr[i][j] = true;
				}
			}

		}
		
		//printArr(arr);
		
		int count=0;//둘레의 길이를 저장할 변수 
		
		//100*100의 사격형을 탐색하며 둘레의 길이를 구한다
		for(int i=1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				
				//가로의 길이를 구한다. 
				if(arr[i-1][j] == false && arr[i][j] ==true) {  //내 위는 비어져 있는데 나는 채워져 있는 경우 
					count++;
				}else if(arr[i][j] == true && arr[i+1][j] ==false) { //나는 채워져 있는데 나 아래를 배워져 있는 경우
					count++;
				}
				
				//세로의 길이를 구한다. 
				if(arr[i][j-1]==false && arr[i][j]==true) { //나는 채워져 있는데, 내 왼쪽은 비어 있는 경우
					count++;
				}else if(arr[i][j+1]==false && arr[i][j]==true) { //나는 채워져 있는데 내 오른쪽은 비어져 있는 경우 
					count++;
				}
				
			}
		}
		System.out.println(count);
		
		
		
		
		
	}
	
	static void printArr(boolean[][] tmp) {
		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<tmp[i].length;j++) {
				if(tmp[i][j]) 
					System.out.print("1 ");
				if(!tmp[i][j]) 
					System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println();
	}

}