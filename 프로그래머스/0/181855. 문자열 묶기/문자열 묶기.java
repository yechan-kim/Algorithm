import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] count = new int[100001];
        
        for(int i=0; i<strArr.length; i++)
            count[strArr[i].length()]++;
        
        return Arrays.stream(count).max().getAsInt();
    }
}