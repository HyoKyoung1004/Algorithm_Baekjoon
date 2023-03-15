import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws Exception{
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb= new StringBuffer();
        int num = Integer.parseInt(br.readLine());
        LinkedList q= new LinkedList();

        for(int i=0;i<num;i++){
            String str = br.readLine();
            if(str ==null) str="";

            String input = str.split(" ")[0];

            if(input.equals("push")){
                int pushItem=  Integer.parseInt(str.split(" ")[1]);
                q.offer(pushItem);
            } else if (input.equals("pop")) {
                if(q.isEmpty()) sb.append("-1\n");
                else{
                    sb.append(q.peek()+"\n");
                    q.poll();
                }
            }else if (input.equals("size")){
                if(q.isEmpty()) sb.append("0\n");
                else sb.append(q.size()+"\n");
            }else if (input.equals("empty")){
                if(q.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }else if (input.equals("front")){
                if(q.isEmpty()) sb.append("-1\n");
                else{
                    sb.append(q.peek()+"\n");
                }
            }else if (input.equals("back")){
                if(q.isEmpty()) sb.append("-1\n");
                else{
                
                    Object obj=q.getLast();
                    sb.append(obj+"\n");

                }
            }
            //System.out.println(q);

        }
        System.out.println(sb);
        br.close();
        //bw.flush();
        //bw.close();
    }
}
