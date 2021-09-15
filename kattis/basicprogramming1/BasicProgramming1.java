import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicProgramming1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] nt = in.nextLine().split(" ");
    int n = Integer.parseInt(nt[0]);
    int t = Integer.parseInt(nt[1]);
    String[] strings = in.nextLine().split(" ");
    List<Integer> ints = new ArrayList<Integer>();
    String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

    for (String s : strings) {
      ints.add(Integer.parseInt(s));
    }

    switch (t) {
      case 1:
        System.out.println("7");
        break;
      case 2:
        if (ints.get(0) > ints.get(1)) {
          System.out.println("Bigger");
        } else if (ints.get(0) < ints.get(1)) {
          System.out.println("Smaller");
        } else {
          System.out.println("Equal");
        }
        break;
      case 3:
        List<Integer> ordered = ints.subList(0, 3);
        Collections.sort(ordered);
        System.out.println(ordered.get(1));
        break;
      case 4:
        int sum = ints.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        break;
      case 5:
        List<Integer> evens = ints.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        int sumEven = evens.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sumEven);
        break;
      case 6:
        List<String> letters = ints.stream().map(i -> alphabet[i % 26]).collect(Collectors.toList());
        System.out.println(String.join("", letters));
        break;
      case 7:
        boolean[] visited = new boolean[n];
        int i = 0;
        while (true) {
          visited[i] = true;
          i = ints.get(i);
          if (i > n - 1) {
            System.out.println("Out");
            break;
          } else if (i == n - 1) {
            System.out.println("Done");
            break;
          } else if (visited[i]) {
            System.out.println("Cyclic");
            break;
          }
        }
        break;
      default:
        break;
    }
  }
}