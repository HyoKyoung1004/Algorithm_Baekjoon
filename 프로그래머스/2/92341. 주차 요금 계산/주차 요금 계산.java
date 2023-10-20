import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<Integer, String> cars = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();

        for(int i=0;i<records.length;i++){
            
            String[] tmp = records[i].split(" ");
            if(tmp[2].equals("IN")){
                cars.put(Integer.parseInt(tmp[1]), tmp[0]);
            }else{
                
                String[] startTime = cars.get(Integer.parseInt(tmp[1])).split(":");
                String[] endTime=  tmp[0].split(":");
                
                int startH = Integer.parseInt(startTime[0]);     
                int startM = Integer.parseInt(startTime[1]);                   
                int endH = Integer.parseInt(endTime[0]);                   
                int endM = Integer.parseInt(endTime[1]);
                int remainM=0;
                if(endM >= startM){
                    remainM =  endM-startM +(endH-startH)*60;
                }else{
                    endH--;
                    remainM = (endM+60-startM)+(endH-startH)*60;
                }
                int carNum = Integer.parseInt(tmp[1]);
                if(result.containsKey(carNum)){
                    result.put(carNum, result.get(carNum)+remainM);
                }else{
                    result.put(carNum, remainM);
                }
                
                cars.remove(carNum);

                
            }
            
            
        }
        //for문을 다 돌았는데도 남아 있는것이 있다.
        for(int num : cars.keySet()){
            String[] startTime = cars.get(num).split(":");
            int startH = Integer.parseInt(startTime[0]);     
            int startM = Integer.parseInt(startTime[1]);  
            int remainM =  59-startM +(23-startH)*60;
                if(result.containsKey(num)){
                    result.put(num, result.get(num)+remainM);
                }else{
                    result.put(num, remainM);
                }            
        }
        System.out.println(result);
        
        ArrayList<Integer> keyList = new ArrayList<>();
        for(int num: result.keySet()){
            int remainM = result.get(num);
            if(remainM <= fees[0]){
                result.put(num, fees[1]);
            }else{
                int money = fees[1];
                money+=Math.ceil((double)(remainM - fees[0])/(double)fees[2]) * fees[3];
                result.put(num, money);
            }
            keyList.add(num);
        }
        
        Collections.sort(keyList);
        int[] answer = new int[keyList.size()];
        
        for(int i=0;i<keyList.size();i++){
            answer[i] =  result.get(keyList.get(i));    
        }
        System.out.println(result);

        
        
        
        return answer;
    }
}