import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int R,C,K;
	static int arr[][], set[], cards[];
	static int[] layerA, layerB;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int tc=1;tc<=TC;tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr= new int[R][C];
			layerA = new int[C];
			layerB = new int[C];

			Arrays.fill(layerA, 0);
			Arrays.fill(layerB, 1);
			for(int i=0;i<R;i++) {
				 st = new StringTokenizer(br.readLine());
				for(int j=0;j<C;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean fistCheck = check(arr);
			if(fistCheck) {
				sb.append("#"+tc+" 0\n");
				continue;
			}
			
			//뽑기 회수를 증가시키면서 뽑기
			for(int i=1;i<=R;i++) {
				cards = new int[i];
				set = new int[i];
				boolean possible = comb(0,0,i);
				if(possible) {
					sb.append("#"+tc+" "+i+"\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}

	
	//어떤 막의 약품을 넣을 지 선택하는 조합 메서드
	private static boolean comb(int cnt, int start, int num) {
		
		if(cnt == num) {
			boolean checkResult = selecdtAorB(0,num);			
			return checkResult;
		}
		
		for(int i=start;i<R;i++) {
			cards[cnt]=i;
			boolean result=comb(cnt+1, i+1, num);
			if(result) return true;
		}
		return false;
		
	}
	
	
	
	private static boolean selecdtAorB(int cnt,int num) {
		
		if(cnt==num) {
			
			int[][] copyArr = copyArr();
			
			for(int i=0;i<num;i++) {
				if(set[i]==0) copyArr[cards[i]] = layerA;
				else copyArr[cards[i]] = layerB;
			}
			
			//toString(copyArr);
			boolean checkResult=check(copyArr);
			
			return checkResult;
		}
		
		for(int i=0;i<=1;i++) {
			set[cnt]=i;
			boolean result=selecdtAorB(cnt+1,num);
			if(result) return true;
		}
		return false;
		
	}


	private static int[][] copyArr() {
		int[][] copyArr = new int[R][];
		for(int i=0;i<R;i++) {
			copyArr[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		return copyArr;
	}
	

	//세로로 연속적인 것이 k개 있는지 확인하는 메서드 
	private static boolean check(int[][] arr) {

		boolean result = true;;
		
		for(int j=0;j<C;j++) {
			Stack<Integer> stack = new Stack<>();
			for(int i=0;i<R;i++) {
				if(stack.isEmpty()) stack.push(arr[i][j]);
				else if(stack.peek()==arr[i][j]) stack.push(arr[i][j]);
				else {
					stack.clear();
					stack.push(arr[i][j]);
				}
				
				if(stack.size()==K) break;
			}
			if(stack.size()<K) {
				result =false;
				break;
			}
		}
		return result;
	}
}
