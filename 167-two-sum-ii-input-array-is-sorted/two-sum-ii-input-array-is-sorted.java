class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        int[] ans = new int[2];
        int i=0, j= n-1;
        while(i!=j){
            if(numbers[i]+numbers[j]<target){
                i++;
            }else if(numbers[i]+numbers[j]>target){
                j--;
            }else{
                break;
            }
        }
        ans[0]=i+1;
        ans[1]=j+1;
        return ans;
    }
}