import java.util.Scanner;

public class TTS {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int stones = in.nextInt();
    int mod = stones % 2;
    if (mod != 1) {
      System.out.println("Bob");
    } else {
      System.out.println("Alice");
    }
  }
}