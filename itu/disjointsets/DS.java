import java.util.Scanner;
import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DS extends UF {

  public DS(int N) {
    super(N);
  }

  public void move(int s, int t) {
    if (find(s) == find(t))
      return;
    // id[s] = id[t];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    DS ds = new DS(n);
    for (int i = 0; i < m; i++) {
      int operation = in.nextInt();
      int s = in.nextInt();
      int t = in.nextInt();
      switch (operation) {
        case 0:
          System.out.println(ds.find(s) == ds.find(t) ? "1" : "0");
          break;
        case 1:
          ds.union(s, t);
          break;
        case 2:
          // ds.move(s, t);
          break;
      }
    }
  }
}
