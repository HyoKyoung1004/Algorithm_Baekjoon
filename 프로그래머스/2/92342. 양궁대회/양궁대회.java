import java.util.*;

class Solution {
    
    static int[] cards;
    static int[] infoCard;
    static int[] result;
    static int n, max=Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {    
        
        this.n = n;
        infoCard = info;
        cards = new int[11];
        result = new int[11];
        
        search(0,n);
        
        if(max==Integer.MIN_VALUE) return new int[]{-1};
        else return result;
        // int[] answer = {};
        // return answer;
    }
    
    static void search(int now, int remain){
        
        if(now==11 || remain==0){
            
            if(remain!=0) return;

            int mySum=0, yourSum=0;
            
            for(int i=0;i<11;i++){
                if(infoCard[i]==0 && cards[i]==0){
                    continue;
                }
                else if(infoCard[i] < cards[i]){
                    mySum+= 10-i;
                }
                else if(infoCard[i] >= cards[i]){
                    yourSum+= 10-i;
                }
            }

            int diffSocre = mySum- yourSum;
            
            if(mySum > yourSum && diffSocre>max){

                //무조건 갱신
                max = diffSocre;
                for(int i=0;i<11;i++){
                    result[i] = cards[i];
                }
            }else if(mySum> yourSum && diffSocre == max){
                // System.out.println("result "+Arrays.toString(result));
                // System.out.println("cards "+Arrays.toString(cards));

                //조건에 따라 update
                for(int i=10;i>=0;i--){
                    if(result[i] == cards[i]) continue;
                    else if(result[i] > cards[i]) break;
                    else{
                       for(int K=0;K<11;K++){
                            result[K] = cards[K];
                        } 
                        break;
                    }
                }
            }
            return;
        }
        
        for(int i=remain;i>=0;i--){
            cards[now]= i;
            search(now+1, remain-i);
        }
    }
}