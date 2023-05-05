import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] A;
    static int[] dp;
    static ArrayList<Integer> listForSize;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A= new int[N][2];
        dp = new int[N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        listForSize = new ArrayList<>();
        listForSize.add(Integer.MIN_VALUE);

        for(int i=0;i<N;i++){

            if(listForSize.get(listForSize.size()-1) < A[i][1]){ //가장 마지막 수열보다 현재 수열이 클 때
                listForSize.add(A[i][1]);
                dp[i] = listForSize.size()-1;
            }else{
                //listForSize에서 A[i]보다 처음으로 크거나 같아지는 원소의 index찾기 : Lower bound
                int index = binarySearch(1,listForSize.size()-1,A[i][1]);
                listForSize.set(index,A[i][1]);
                dp[i]=index;
            }
        }
        int LISLength = listForSize.size() - 1;

        System.out.println(N-LISLength); //삭제 길이


        //뒤에서부터 탐색하며, LIS출력
        Stack<Integer> stack = new Stack<>();
        int index =LISLength;
        for(int i=N-1;i>=0;i--){
            if(dp[i] == index) {
                //stack.push(A[i]);
                index--;
            }else{
                stack.push(A[i][0]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+"\n");
        }
        System.out.println(sb);

    }

    //현재 수열이 들어갈 수 있는 위치를 빠르게 찾아주기 위한 바이너리 서치 구현하기
    private static int binarySearch(int left, int right, int target) {
        while(left<right){
            int mid = (left+right)/2;
            if(target> listForSize.get(mid))
                left = mid+1;
            else right=mid;
        }
        return left;
    }
}