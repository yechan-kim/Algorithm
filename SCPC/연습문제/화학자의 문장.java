/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static String Answer;
    static int DP[];
    static String input;
    static List<String> elements = new ArrayList<>();


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

        String[] element = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
                "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se",
                "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
                "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi",
                "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Fl", "Lv", "La",
                "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac", "Th", "Pa",
                "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr"};

        for (int i = 0; i < element.length; i++) {
            element[i] = element[i].toUpperCase();
            elements.add(element[i]);
        }

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = "";
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            input = sc.next().toUpperCase();
            DP = new int[input.length()];

            if (chemString(0)) Answer = "YES";
            else Answer = "NO";

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }

    private static boolean chemString(int index) {
        if (index == input.length())
            return true;

        if (DP[index] == -1) {
            return false;
        }
        if (DP[index] == 1) {

            if (index > 0 && DP[index - 1] == -1)
                return false;
            else {
                if (isContains(index)) {
                    DP[index + 1] = 1;
                    return chemString(index + 2);
                }
            }
        }

        if (isContain(index)) {
            DP[index] = 1;
            return chemString(index + 1);
        } else if (index < input.length() - 1 && isContains(index)) {
            DP[index] = -1;
            DP[index + 1] = 1;
            return chemString(index + 2);
        } else {
            if (index == 0) return false;
            DP[index] = -1;
            return chemString(index - 1);
        }

    }

    private static boolean isContain(int i) {
        String s = input.charAt(i) + "";
        if (elements.contains(s)) return true;
        else return false;
    }

    private static boolean isContains(int i) {
        String s = input.charAt(i) + "" + input.charAt(i + 1);
        if (elements.contains(s)) return true;
        else return false;
    }
}