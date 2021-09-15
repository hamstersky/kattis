import java.util.Scanner;

public class NineKnights {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] board = new String[5][5];
        for (int i = 0; i < 5; i++) {
            board[i] = in.nextLine().split("");
        }
        
        int knights = 0;
        int[] rows = new int[] {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] cols = new int[] {-1, 1, -2, 2, -2, 2, -1, 1};
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (!board[r][c].equals("k")) continue;
                knights++;
                for (int i = 0; i < 8; i++) {
                    boolean rInBound = r + rows[i] >= 0 && r + rows[i] < 5;
                    boolean cInBound = c + cols[i] >= 0 && c + cols[i] < 5;
                    if (rInBound && cInBound && board[r+rows[i]][c+cols[i]].equals("k")) {
                        System.out.println("invalid");
                        return;
                    } 
                }
            }
        }
        System.out.println(knights == 9 ? "valid" : "invalid");
    }
}