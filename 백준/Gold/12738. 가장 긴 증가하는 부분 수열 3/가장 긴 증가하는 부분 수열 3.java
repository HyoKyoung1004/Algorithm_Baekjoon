import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Long[] A;
	static ArrayList<Long> al = new ArrayList<>();
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new Long[N];
		for(int i=0;i<N;i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		al.add(Long.MIN_VALUE);
		
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
	private static int binarySearch(int left, int right, long target) {
        while(left<right){
            int mid = (left+right)/2;
            if(target> al.get(mid))
                left = mid+1;
            else right=mid;
        }
        return left;
    }
	

}
