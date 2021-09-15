import java.util.Scanner;

public class Aaah {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String jon = in.nextLine();
    String doc = in.nextLine();
    if (jon.length() >= doc.length()) {
      System.out.println("go");
    } else {
      System.out.println("no");
    }
  }
}