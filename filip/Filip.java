import java.util.Scanner;

public class Filip {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String x = reverseString(in.next());
    String y = reverseString(in.next());
    if (x.compareTo(y) > 0) {
      System.out.println(x);
    } else {
      System.out.println(y);
    }
  }

  public static String reverseString(String s) {
    String reversedString = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      reversedString += s.charAt(i);
    }
    return reversedString;
  }
}