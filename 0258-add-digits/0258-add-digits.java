class Solution {
    public int addDigits(int num) {
        // mod-remainder
        // divide-floor
        
        while(Math.floor(num/10)!=0){
            int sum=0;
            while(num>0){
                sum+=num%10;
                num=num/10;
            }
            // sum=num;
            num=sum;
        }
        return num;
    }
}