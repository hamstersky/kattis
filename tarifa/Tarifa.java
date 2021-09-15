import java.util.Scanner;

public class Tarifa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int N = in.nextInt();
        int bandwith = X * (N+1);
        int used = 0;
        for (int i = 0; i < N; i++) {
            used += in.nextInt();
        }
        System.out.println(bandwith - used);
    }
}