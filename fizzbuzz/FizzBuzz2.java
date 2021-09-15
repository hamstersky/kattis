import java.util.Scanner;

public class FizzBuzz2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();
        int N = in.nextInt();

        for (int i = 1; i <= N; i++) {
            if (i % X == 0) {
                System.out.println("Fizz");
            } else if (i % Y == 0) {
                System.out.println("Buzz");
            } else if (i % X == 0 && i % Y == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
