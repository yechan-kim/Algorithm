import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        int X = scan.nextInt();

        int A[]= new int[N];
        for(int i=0; i<N; i++)
            A[i] = scan.nextInt();

        for(int i=0; i<N; i++)
        {
            if(A[i] < X)
                System.out.print(A[i] + " ");
        }
    }
}