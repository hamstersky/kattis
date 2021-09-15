import java.util.Scanner;

public class FizzBuzz {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    int y = in.nextInt();
    int n = in.nextInt();
    FizzBuzz fizzbuzz = new FizzBuzz();
    for (int i = 1; i <= n; i++) {
      fizzbuzz.replace(x, y, i);
    }
  }

  private void replace(int x, int y, int n) {
    if (divisibleBy(n, x) && divisibleBy(n, y)) {
      System.out.println("FizzBuzz");
    } else if (divisibleBy(n, x)) {
      System.out.println("Fizz");
    } else if (divisibleBy(n, y)) {
      System.out.println("Buzz");
    } else {
      System.out.println(n);
    }
  }

  private boolean divisibleBy(int x, int y) {
    return x % y == 0;
  }
}