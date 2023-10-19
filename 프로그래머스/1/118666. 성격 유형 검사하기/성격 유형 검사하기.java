import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);

        for(int i=0; i<survey.length;i++){
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            if(choices[i]<=3){
                map.put(c1, map.get(c1)+ 4-choices[i]);
            }else if(choices[i]>=5){
               map.put(c2, map.get(c2)+ choices[i]-4);
            }
            
            System.out.println(map);
        }

        
        String answer = "";
        answer +=  map.put('T',0)> map.put('R',0) ? "T" :"R";
        answer +=  map.put('C',0)>= map.put('F',0) ?"C" :"F";
        answer +=  map.put('J',0)>= map.put('M',0) ?"J" :"M";
        answer +=  map.put('A',0)>= map.put('N',0) ?"A" :"N";

        return answer;
        
    }
}