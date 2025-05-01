class Solution {
    public int addDigits(int num) {
        // mod-remainder
        // divide-floor
        
        while(num>=10){
            int sum=0;
            while(num!=0){
                sum+=num%10;
                num=num/10;
            }
            // sum=num;
            num=sum;
        }
        return num;
    }
}