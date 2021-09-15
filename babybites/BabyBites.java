import java.util.Scanner;

public class BabyBites {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        // Get rid of the newline
        in.nextLine();
        String[] line = in.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (!line[i].equals("mumble") && Integer.parseInt(line[i]) != i+1) {
                System.out.println("something is fishy");
                return;
            }
        }
        System.out.println("makes sense");
    }
}