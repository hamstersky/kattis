import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lineup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        // Get rid of the newline
        in.nextLine();
        // System.out.println(streams(in, N));
        System.out.println(loop(in, N));
    }

    public static String streams(Scanner in, int N) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            names.add(in.nextLine());
        }

        boolean increasing = names.stream().sorted().collect(Collectors.toList()).equals(names);
        
        boolean decreasing = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).equals(names);
        
        if (increasing) {
            return "INCREASING";
        } else if (decreasing) {
            return "DECREASING";
        } else {
            return "NEITHER";
        }
    }

    public static String loop(Scanner in, int N) {
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = in.nextLine();
        }
        
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < N; i++) {
            if (i+1 < N && names[i].compareTo(names[i+1]) > 0) {
                increasing = false;
            } else if (i+1 < N && names[i].compareTo(names[i+1]) < 0) {
                decreasing = false;
            }
        }

        if (increasing) {
            return "INCREASING";
        } else if (decreasing) {
            return "DECREASING";
        } else {
            return "NEITHER";
        }
    }
}