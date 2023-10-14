import java.util.*;
import java.text.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception {
        
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<String, Integer>  map = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            
            String[] tmp = terms[i].split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }
       // System.out.println(map);
        
        String[] todayDate = today.split("\\.");
        //System.out.println(today);
        //System.out.println(Arrays.toString(todayDate));

        int todayDays = Integer.parseInt(todayDate[0])*12*28 + Integer.parseInt(todayDate[1])*28 +Integer.parseInt(todayDate[2]);
        
        for(int i=0;i<privacies.length;i++){
            String[] tmp = privacies[i].split(" ");
            String[] date = tmp[0].split("\\.");
            Integer month = map.get(tmp[1]);
            
            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(date[2]);
            
            int startDate = y*12*28 + m*28 + d;
            int endDate = startDate +(month*28)-1;//보관가능날짜
        
          //  System.out.println(startDate+", "+endDate+", "+todayDays);
            if(endDate < todayDays) 
                result.add(i+1);
            
        }
        
        System.out.println(result);
        
        
        int[] answer = new int[result.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}