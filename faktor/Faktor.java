import java.util.Scanner;

public class Faktor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int I = in.nextInt();
        // System.out.println(brute_force(A, I));
        System.out.println(formula(A, I));
    }

    public static int brute_force(int A, int I) {
        int C = A * I;
        while (1.0 * C / A > I - 1) {
            C--;
        }
        // The way the condition of the loop is set up, the loop stops on a
        // value of C such that C/A <= I-1, so we need to increment it by 1
        // before returning it
        return C + 1;
    }

    public static int formula(int A, int I) {
        // We know that C/A is somewhere between I and I-1 (excluding). That is:
        // I - 1 < C/A <= I
        // If we isolate C, we get:
        // A(I - 1) < C <= A*I
        // We're looking for the minimum value of C that satisfies the above.
        // Since C is an integer, the smallest C that satisfied the left part of
        // the inequality is greater by 1 (the smallest positive integer):
        // A(I - 1) + 1
        return A*(I-1) + 1;
    }
}