import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sumY = 0;
        int sumM = 0;

        for (int i = 0; i < N; i++) {
            sumY += (arr[i] / 30 + 1) * 10;
            sumM += (arr[i] / 60 + 1) * 15;
        }

        if (sumY < sumM) {
            bw.write("Y " + sumY);
        } else if (sumY > sumM) {
            bw.write("M " + sumM);
        } else {
            bw.write("Y M " + sumY);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}