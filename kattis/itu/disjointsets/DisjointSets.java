import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DisjointSets {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    List<List<Integer>> operations = new ArrayList<>();
    List<Set<Integer>> sets = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      operations.add(new ArrayList<>());
      operations.get(i).add(in.nextInt());
      operations.get(i).add(in.nextInt());
      operations.get(i).add(in.nextInt());
    }
    for (int i = 0; i < n; i++) {
      sets.add(new HashSet<>());
      sets.get(i).add(i);
    }
    for (List<Integer> operation : operations) {
      Set<Integer> s = new HashSet<>();
      Set<Integer> t = new HashSet<>();
      for (Set<Integer> set : sets) {
        if (set.contains(operation.get(1))) {
          s = set;
        }
        if (set.contains(operation.get(2))) {
          t = set;
        }
      }
      switch (operation.get(0)) {
        case 0:
          if (s.equals(t)) {
            System.out.println(1);
          } else {
            System.out.println(0);
          }
          break;
        case 1:
          if (!s.equals(t)) {
            s.addAll(t);
            sets.remove(t);
          }
          break;
        case 2:
          if (!s.equals(t)) {
            s.remove(operation.get(1));
            t.add(operation.get(1));
          }
          break;
      }
    }
  }

}