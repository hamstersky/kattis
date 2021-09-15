import java.util.Scanner;

public class IsItHalloween {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String date = in.nextLine();
    if (date.equals("OCT 31") || date.equals("DEC 25")) {
      System.out.println("yup");
    } else {
      System.out.println("nope");
    }
  }
}