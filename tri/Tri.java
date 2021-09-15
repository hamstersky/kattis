import java.util.Scanner;

public class Tri {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();

    if (a + b == c) {
      System.out.println(a + "+" + b + "=" + c);
    } else if (a - b == c) {
      System.out.println(a + "-" + b + "=" + c);
    } else if (a * b == c) {
      System.out.println(a + "*" + b + "=" + c);
    } else if (a / b == c) {
      System.out.println(a + "/" + b + "=" + c);
    } else if (b + c == a) {
      System.out.println(a + "=" + b + "+" + c);
    } else if (b - c == a) {
      System.out.println(a + "=" + b + "-" + c);
    } else if (b * c == a) {
      System.out.println(a + "=" + b + "*" + c);
    } else {
      System.out.println(a + "=" + b + "/" + c);
    }
  }

}