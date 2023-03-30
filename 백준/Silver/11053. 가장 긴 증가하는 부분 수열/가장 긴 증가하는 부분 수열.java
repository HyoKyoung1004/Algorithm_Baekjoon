import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;
	static ArrayList<Integer> al = new ArrayList<>();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		al.add(0);
		
		for(int i=0;i<N;i++) {
			if(al.get(al.size()-1)<A[i])
				al.add(A[i]);
			else {
				int index =binarySearch(1,al.size()-1,A[i]);
				al.set(index, A[i]);
			}
		}
		
		System.out.println(al.size()-1);
		
		
		
		
		
	}
	private static int binarySearch(int left, int right, int target) {
        while(left<right){
            int mid = (left+right)/2;
            if(target> al.get(mid))
                left = mid+1;
            else right=mid;
        }
        return left;
    }
	

}
