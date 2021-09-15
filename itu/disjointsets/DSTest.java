import java.util.Scanner;

// This solution is heavily inspired by the book “Algorithms, 4th Edition” by Sedgewick and Wayne and some code comes straight from the examples of the book.
// It uses the quick-find implementation which was fast enough to pass the Kattis assignment with a score of 100.

public class DSTest {
  private int[] id;
  private int N;

  public DSTest(int N, int M) {
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
    if (find(s) == find(t))
      return;

    for (int i = 0; i < N; i++) {
      if (id[i] == id[s]) {
        id[i] = id[t];
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
    DSTest ds = new DSTest(n, m);
    ds.union(0, 2);
  }
}
