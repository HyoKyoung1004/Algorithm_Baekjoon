import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N,d,k,c;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		d= Integer.parseInt(st.nextToken());
		k= Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());
		
		
		int max = 0;
		int[] arr = new int[N+k-1];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<k-1;i++) {
			arr[N+i] = arr[i];
		}
		
		//System.out.println(Arrays.toString(arr));
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(c, 1);
		for(int i=0;i<k;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		max = Math.max(map.size(), max);
		
		for(int i=k;i<arr.length;i++) {
			
			map.put(arr[i-k], map.getOrDefault(arr[i-k], 0)-1);
			if(map.get(arr[i-k])==0) map.remove(arr[i-k]);

			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			max = Math.max(map.size(), max);
		}
		
		System.out.println(max);
		
	}

}
