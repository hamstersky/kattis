import java.util.Scanner;

public class Cetvrta {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] coords = new int[3][2];
        int x1 = in.nextInt(), y1 = in.nextInt();
        int x2 = in.nextInt(), y2 = in.nextInt();
        int x3 = in.nextInt(), y3 = in.nextInt();
        int x4, y4;

        if (x1 == x2) {
            x4 = x3;
        } else if (x1 == x3) {
            x4 = x2;
        } else {
            x4 = x1;
        }

        if (y1 == y2) {
            y4 = y3;
        } else if (y1 == y3) {
            y4 = y2;
        } else {
            y4 = y1;
        }

        System.out.printf("%s %s", x4, y4);
    }
}