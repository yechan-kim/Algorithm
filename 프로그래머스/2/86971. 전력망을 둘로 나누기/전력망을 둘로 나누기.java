import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        int size = wires.length;
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<size; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for(int i=0; i<size; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            visited = new boolean[n+1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1);
            
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    public int dfs(int v){
        visited[v] = true;
        int cnt = 1;
        
        for(int next : graph[v]){
            if(!visited[next]){
                cnt += dfs(next);
            }
        }
        
        return cnt;
    }
}