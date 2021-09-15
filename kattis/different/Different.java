import java.util.Scanner;

public class Different {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      long x = in.nextLong();
      long y = in.nextLong();
      System.out.println(Math.abs(x - y));
    }
  }
}