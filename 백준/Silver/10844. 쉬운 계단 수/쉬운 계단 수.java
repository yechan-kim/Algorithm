import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        final long MOD = 1000000000L;

        long[][] dp = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];

            for (int j = 1; j <= 9; j++) {
                if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}