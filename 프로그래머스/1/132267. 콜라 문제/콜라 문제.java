class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n / a != 0){
            int temp = n%a;
            n = b * (n/a);
            answer += n;
            n += temp;
        }
        
        return answer;
    }
}