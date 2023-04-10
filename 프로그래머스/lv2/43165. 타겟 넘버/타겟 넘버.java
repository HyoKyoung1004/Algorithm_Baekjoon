import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    
    static int[] numberArr;
    static boolean[] isSelected;
    static int size, targetNum, result;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        numberArr = numbers;
        targetNum = target;
        size = numbers.length;
        isSelected = new boolean[size];
        // System.out.println(size);
        powerSet(0);
        //System.out.println(result);
        return result;
    }
    private static void powerSet(int cnt){
        if(cnt==size){
            //System.out.println(Arrays.toString(isSelected));
            int sum=0;
            for(int i=0;i<size;i++){
                if(isSelected[i]) sum+= numberArr[i];
                else sum -= numberArr[i];
            }
            
            if(sum == targetNum) result++;
            return;
        }
        
        isSelected[cnt] = true;
        powerSet(cnt+1);
        
        isSelected[cnt] = false;
        powerSet(cnt+1);
        
    }
    
    

}