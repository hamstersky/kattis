import java.util.Scanner;

public class Cold {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int counter = 0;
        for (int i = 0; i < N; i++) {
            if (in.nextInt() < 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}