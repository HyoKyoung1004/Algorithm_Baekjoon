import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
       long result = 0;

        //int lastIndex = n-1;
        //int pickupIndex = n-1;
        
        for(int i=n-1 ;i >=0; ){
            
            if(deliveries[i] ==0 && pickups[i]==0){
                --i;
                continue;
            }
            
            result += (i+1)*2L;
            
            int tmpCap=0;
            int lastIndex=i;
            while(tmpCap < cap && lastIndex>=0){
                if(tmpCap + deliveries[lastIndex] <=cap){
                    tmpCap += deliveries[lastIndex];
                    deliveries[lastIndex]=0;
                    lastIndex--;
                }else{
                    int remain =cap-tmpCap;
                    deliveries[lastIndex] -= remain;
                    tmpCap+= remain;
                }
            }
            
            //System.out.println(Arrays.toString(deliveries));

            int pickupIndex=i;
            int returnCap =0;
              while(returnCap < cap&& pickupIndex>=0){
                if(returnCap + pickups[pickupIndex] <=cap){
                    returnCap += pickups[pickupIndex];
                    pickups[pickupIndex]=0;
                    pickupIndex--;
                }else{
                    int remain =cap-returnCap;
                    pickups[pickupIndex] -= remain;
                    returnCap+= remain;
                }
            }
        // System.out.println(Arrays.toString(pickups));

            
        }
        
        
        
        
        return result;
    }
}