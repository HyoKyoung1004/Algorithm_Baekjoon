import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb= new StringBuffer();

        for(int i=0;i<n;i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));
            else if(command.equals("pop")){
                if(stack.empty()) sb.append(-1+"\n");
                else sb.append(stack.pop()+"\n");
            } else if(command.equals("size")){
               sb.append(stack.size()+"\n");
            }
            else if(command.equals("empty")){
                if(stack.empty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }
            else if(command.equals("top")){
                if(stack.empty()) sb.append(-1+"\n");
                else sb.append(stack.peek()+"\n");
            }

        }
        System.out.println(sb);

    }
}
