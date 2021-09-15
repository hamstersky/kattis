import java.util.Scanner;

public class Spavanac {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int hours = in.nextInt();
    int minutes = in.nextInt();
    if (minutes - 45 < 0) {
      minutes = 60 + (minutes - 45);
      hours = (hours == 0) ? 23 : --hours;
    } else {
      minutes = minutes - 45;
    }
    System.out.println(hours + " " + minutes);
  }
}