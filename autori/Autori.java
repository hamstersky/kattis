import java.util.Scanner;

public class Autori {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] authors = in.nextLine().split("-");
    String shortAuthors = "";
    for (String author : authors) {
      shortAuthors += author.charAt(0);
    }
    System.out.println(shortAuthors);
  }
}