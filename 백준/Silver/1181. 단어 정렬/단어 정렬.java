import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class StringlengthCom implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        if(s1.length()== s2.length())
            return s1.compareTo(s2);
        else return s1.length()-s2.length();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int num= Integer.parseInt(br.readLine());

       // int num=14;
        //String[] st = {"but","i","wont","hesitate","no","more","more","no","more","it","cannot","wait","im","yours"};
        String[] st = new String[num];

        for(int i=0;i<num;i++){
            st[i] = br.readLine();
        }
       // System.out.println(Arrays.toString(st));
        Arrays.sort(st,new StringlengthCom());
       // System.out.println(Arrays.toString(st));

        StringBuffer sb= new StringBuffer();
        sb.append(st[0]+"\n");
        for(int i=1;i< st.length;i++){
            if(!st[i].equals(st[i-1])){
                sb.append(st[i]+"\n");
            }
        }
        System.out.println(sb);
    }
}


