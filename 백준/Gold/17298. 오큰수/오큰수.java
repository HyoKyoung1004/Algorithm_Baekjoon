import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){

            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && arr[stack.peek()] <arr[i]){
                        result[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }

        while(!stack.isEmpty()){
            result[stack.pop()]=-1;
        }

        StringBuffer sb= new StringBuffer();
        for(int i=0;i<n;i++){
            sb.append(result[i]+" ");
        }
        System.out.println(sb);

    }
}
