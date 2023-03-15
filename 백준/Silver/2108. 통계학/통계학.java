import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.jar.JarEntry;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] list = new int[num];
        int sum=0;
        for(int i=0;i<num;i++){
            list[i] = Integer.parseInt(br.readLine());
            sum+=list[i];

        }

        StringBuffer sb= new StringBuffer();

        //산술평균
        float avg = sum/(float)num;
        sum =(int)(Math.round(avg)*10)/10;
        sb.append(sum+"\n");



        //중앙값
        Arrays.sort(list);
        int middleNum= list[(1+num)/2 -1];
        sb.append(middleNum+"\n");


        //최빈값
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i< list.length;i++){
            if(map.containsKey(list[i])){
                map.put(list[i], map.get(list[i])+1);
            }else{
                map.put(list[i],1);
            }
        }

        Collection value = map.values();
        int max = (int)Collections.max(value);
        List arr = new ArrayList<>();

        //System.out.println("최반값: "+max);
        Iterator it= map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry e= (Map.Entry) it.next();
            if((int)e.getValue() ==max )
                arr.add(e.getKey());
        }

       // System.out.println(arr);
        Collections.sort(arr);
        if(arr.size()==1) sb.append(arr.get(0)+"\n");
        else sb.append(arr.get(1)+"\n");


        //범위
        int range = list[num-1]- list[0];
        sb.append(range+"\n");


        System.out.println(sb);
    }
}
