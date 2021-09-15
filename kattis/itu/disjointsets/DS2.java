import java.util.Scanner;

// This solution is heavily inspired by the book “Algorithms, 4th Edition” by Sedgewick and Wayne and some code comes straight from the examples of the book.
// It uses the quick-find implementation which was fast enough to pass the Kattis assignment with a score of 100.

public class DS2 {
  private int[] id;
  private int N;

  public DS2(int N, int M) {
    id = new int[N];
    this.N = N;
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int find(int s) {
    return id[s];
  }

  public boolean connected(int s, int t) {
    return find(s) == find(t);
  }

  public void union(int s, int t) {
    int sID = find(s);
    int tID = find(t);

    if (sID == tID)
      return;

    for (int i = 0; i < N; i++) {
      if (id[i] == sID) {
        id[i] = tID;
      }
    }
  }

  public void move(int s, int t) {
    if (connected(s, t))
      return;
    id[s] = id[t];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    DS2 ds = new DS2(n, m);
    for (int i = 0; i < m; i++) {
      int operation = in.nextInt();
      int s = in.nextInt();
      int t = in.nextInt();
      switch (operation) {
        case 0:
          System.out.println(ds.connected(s, t) ? "1" : "0");
          break;
        case 1:
          ds.union(s, t);
          break;
        case 2:
          ds.move(s, t);
          break;
      }
    }
  }
}
