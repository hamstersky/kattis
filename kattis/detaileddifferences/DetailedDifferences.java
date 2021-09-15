import java.util.Scanner;

public class DetailedDifferences {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numberOfPairs = in.nextInt();
    in.nextLine();
    String differences = "";
    for (int i = 0; i < numberOfPairs; i++) {
      String s1 = in.nextLine();
      String s2 = in.nextLine();
      differences += s1 + "\n" + s2 + "\n";
      for (int j = 0; j < s1.length(); j++) {
        if (s1.charAt(j) == (s2.charAt(j))) {
          differences += ".";
        } else {
          differences += "*";
        }
      }
      differences += "\n";
    }
    System.out.println(differences);
  }
}