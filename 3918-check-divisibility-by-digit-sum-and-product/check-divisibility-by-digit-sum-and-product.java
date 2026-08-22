class Solution {
    public boolean checkDivisibility(int n) {
        int d=n, sum=0, pro=1;
        while(n>0){
            int a = n%10;
            sum+=a;
            pro *=a;
            n= n/10;
        }
        if(d%(sum+pro)==0) return true;
        return false;
    }
}