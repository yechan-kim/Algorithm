/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static int Answer;

    public static void main(String args[]) throws Exception {
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int N = sc.nextInt();
            int S = sc.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int start, end;
            start = end = 0;
            int sum = 0;
            int ans = Integer.MAX_VALUE;

            while (start <= end && start < N) {
                if (sum >= S) {
                    ans = Math.min(ans, end - start);
                    sum -= arr[start];
                    start++;
                } else if (end < N) {
                    sum += arr[end];
                    end++;
                } else
                    break;

            }
            Answer = (ans == Integer.MAX_VALUE ? 0 : ans);

            // Print the answer to standard output(screen).
            System.out.println("#testcase" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}