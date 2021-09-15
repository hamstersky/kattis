import java.util.Scanner;

import edu.princeton.cs.algs4.Merge;

public class Grades {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    in.nextLine();
    Grade[] a = new Grade[N];
    for (int i = 0; i < N; i++) {
      a[i] = new Grade(in.nextLine());
    }
    Merge.sort(a);
    for (int i = 0; i < N; i++) {
      System.out.println(a[i].getName());
    }
  }

  static class Grade implements Comparable<Grade> {
    private String grade;
    private String name;

    public Grade(String grade) {
      String[] split = grade.split(" ");
      // Avoid dealing with comparing FX. In the output, we only display the name anyway
      if (split[1].contains("FX")) {
        this.grade = "F" + split[1].substring(2, split[1].length());
      } else if (split[1].contains("F")) {
        this.grade = "G" + split[1].substring(1, split[1].length());
      } else {
        this.grade = split[1];
      }
      this.name = split[0];
    }

    public String getName() {
      return name;
    }

    @Override
    public int compareTo(Grade that) {
      // The letters differ
      if (grade.substring(0, 1).compareTo(that.grade.substring(0, 1)) < 0) {
        return -1;
      } else if (grade.substring(0, 1).compareTo(that.grade.substring(0, 1)) > 0) {
        return 1;
        // If exactly the same then compare names
      } else if (grade.equals(that.grade)) {
        if (name.compareTo(that.name) < 0) {
          return -1;
        } else if (name.compareTo(that.name) > 0) {
          return 1;
        }
        // Need to compare + and -
      } else {
        // Both have +
        if (grade.contains("+") && that.grade.contains("+")) {
          // Longer string means more + so it's greater
          if (grade.length() > that.grade.length()) {
            return -1;
          } else if (grade.length() < that.grade.length()) {
            return 1;
            // If equal length, compare names
          } else {
            if (name.compareTo(that.name) < 0) {
              return -1;
            } else if (name.compareTo(that.name) > 0) {
              return 1;
            }
          }
          // Both have -
        } else if (grade.contains("-") && that.grade.contains("-")) {
          // Longer string means more - so it's lower
          if (grade.length() > that.grade.length()) {
            return 1;
          } else if (grade.length() < that.grade.length()) {
            return -1;
            // If equal length, compare names
          } else {
            if (name.compareTo(that.name) < 0) {
              return -1;
            } else if (name.compareTo(that.name) > 0) {
              return 1;
            }
          }
          // They differ in + and -
        } else {
          // Need to handle edge cases where one has +/- but the other just a letter
          if (grade.contains("-") && that.grade.length() == 1 || grade.length() == 1 && that.grade.contains("+")) {
            return 1;
          } else if (grade.length() == 1 && that.grade.contains("-") || grade.contains("+") && that.grade.length() == 1) {
            return -1;
            // Java by default considers - > + so we need to reverse that
          } else if (grade.compareTo(that.grade) < 0) {
            return -1;
          } else if (grade.compareTo(that.grade) > 1) {
            return 1;
          }
        }
      }
      return 0;
    }
  }
}