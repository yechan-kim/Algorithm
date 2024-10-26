import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        int n = Integer.parseInt(br.readLine());

        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
