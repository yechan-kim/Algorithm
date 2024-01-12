import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long result = 0;
        long pow = 1;

        for (int i = 0; i < L; i++){
            result += (str.charAt(i) - 'a' + 1) * pow;
            pow = (pow * 31) % 1234567891;
        }

        bw.write(String.valueOf(result % 1234567891));

        bw.flush();
        bw.close();
        br.close();
    }
}