import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> list;
    static int last=0;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];

        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,  (o1,o2) -> {
                        if(o1[0] ==o2[0]) return o1[1] -o2[1];
                        return o1[0] -o2[0];
                    }
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //minHeap
        for(int n=0;n<N;n++){
            pq.add(arr[n][1]);
            if(!pq.isEmpty() &&pq.peek() <= arr[n][0])
                pq.poll();
        }
        System.out.println(pq.size());

    }

}
