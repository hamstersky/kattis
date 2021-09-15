
/******************************************************************************
 *  Compilation:  javac UF3.java
 *  Execution:    java UF3 < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Weighted quick-union by rank with path compression by halving.
 *
 *  % java UF3 < tinyUF.txt
 *  4 3
 *  3 8
 *  6 5
 *  9 4
 *  2 1
 *  5 0
 *  7 2
 *  6 1
 *  2 components
 *
 ******************************************************************************/

import java.util.Scanner;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * The {@code UF3} class represents a <em>union–find data type</em> (also known
 * as the <em>disjoint-sets data type</em>). It supports the classic
 * <em>union</em> and <em>find</em> operations, along with a <em>count</em>
 * operation that returns the total number of sets.
 * <p>
 * The union–find data type models a collection of sets containing <em>n</em>
 * elements, with each element in exactly one set. The elements are named 0
 * through <em>n</em>–1. Initially, there are <em>n</em> sets, with each element
 * in its own set. The <em>canonical element</em> of a set (also known as the
 * <em>root</em>, <em>identifier</em>, <em>leader</em>, or <em>set
 * representative</em>) is one distinguished element in the set. Here is a
 * summary of the operations:
 * <ul>
 * <li><em>find</em>(<em>p</em>) returns the canonical element of the set
 * containing <em>p</em>. The <em>find</em> operation returns the same value for
 * two elements if and only if they are in the same set.
 * <li><em>union</em>(<em>p</em>, <em>q</em>) merges the set containing element
 * <em>p</em> with the set containing element <em>q</em>. That is, if <em>p</em>
 * and <em>q</em> are in different sets, replace these two sets with a new set
 * that is the union of the two.
 * <li><em>count</em>() returns the number of sets.
 * </ul>
 * <p>
 * The canonical element of a set can change only when the set itself changes
 * during a call to <em>union</em>&mdash;it cannot change during a call to
 * either <em>find</em> or <em>count</em>.
 * <p>
 * This implementation uses <em>weighted quick union by rank</em> with <em>path
 * compression by halving</em>. The constructor takes &Theta;(<em>n</em>) time,
 * where <em>n</em> is the number of elements. The <em>union</em> and
 * <em>find</em> operations take &Theta;(log <em>n</em>) time in the worst case.
 * The <em>count</em> operation takes &Theta;(1) time. Moreover, starting from
 * an empty data structure with <em>n</em> sites, any intermixed sequence of
 * <em>m</em> <em>union</em> and <em>find</em> operations takes
 * <em>O</em>(<em>m</em> &alpha;(<em>n</em>)) time, where &alpha;(<em>n</em>) is
 * the inverse of <a href =
 * "https://en.wikipedia.org/wiki/Ackermann_function#Inverse">Ackermann's
 * function</a>.
 * <p>
 * For alternative implementations of the same API, see {@link QuickUnionUF},
 * {@link QuickFindUF}, and {@link WeightedQuickUnionUF}. For additional
 * documentation, see <a href="https://algs4.cs.princeton.edu/15uf">Section
 * 1.5</a> of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin
 * Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */

public class UF3 {

  private int[] parent; // parent[i] = parent of i
  private byte[] rank; // rank[i] = rank of subtree rooted at i (never more than 31)
  private int count; // number of components
  private int[] leaves; // keep track of leave nodes, 0 means that it's not a leaf, 1 means that it's a
                        // leaf

  /**
   * Initializes an empty union-find data structure with {@code n} elements
   * {@code 0} through {@code n-1}. Initially, each elements is in its own set.
   *
   * @param n the number of elements
   * @throws IllegalArgumentException if {@code n < 0}
   */
  public UF3(int n) {
    if (n < 0)
      throw new IllegalArgumentException();
    count = n;
    parent = new int[n];
    rank = new byte[n];
    leaves = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 0;
      leaves[i] = 1;
    }
  }

  /**
   * Returns the canonical element of the set containing element {@code p}.
   *
   * @param p an element
   * @return the canonical element of the set containing {@code p}
   * @throws IllegalArgumentException unless {@code 0 <= p < n}
   */
  public int find(int p) {
    validate(p);
    while (p != parent[p]) {
      parent[p] = parent[parent[p]]; // path compression by halving
      p = parent[p];
    }
    return p;
  }

  /**
   * Returns the number of sets.
   *
   * @return the number of sets (between {@code 1} and {@code n})
   */
  public int count() {
    return count;
  }

  /**
   * Returns true if the two elements are in the same set.
   *
   * @param p one element
   * @param q the other element
   * @return {@code true} if {@code p} and {@code q} are in the same set;
   *         {@code false} otherwise
   * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
   *                                  {@code 0 <= q < n}
   * @deprecated Replace with two calls to {@link #find(int)}.
   */
  @Deprecated
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * Merges the set containing element {@code p} with the the set containing
   * element {@code q}.
   *
   * @param p one element
   * @param q the other element
   * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
   *                                  {@code 0 <= q < n}
   */
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ)
      return;

    // make root of smaller rank point to root of larger rank
    if (rank[rootP] < rank[rootQ]) {
      parent[rootP] = rootQ;
      leaves[rootQ] = 0;
    } else if (rank[rootP] > rank[rootQ]) {
      parent[rootQ] = rootP;
      leaves[rootP] = 0;
    } else {
      parent[rootQ] = rootP;
      rank[rootP]++;
      leaves[rootP] = 0;
    }
    count--;
  }

  public void move(int p, int q) {
    // for (int j = 0; j < parent.length - 1; j++) {
    // if (parent[j] == p && j != 1 && j != p) {
    // if (parent[i] == p) {
    // parent[i] = i;
    // }
    // if (parent[j] == p) {
    // parent[j] = j;
    // }
    // union(i, j);
    // }
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ)
      return;
    if (leaves[rootP] == 1) {
      parent[p] = rootQ;
    } else {
      for (int i = 0; i < parent.length; i++) {
        // Check if the same tree
        if (find(i) == rootP) {
          // if (parent[i] == p) {

          // }
          if (leaves[i] == 1) {
            // point i's parent to itself
            parent[i] = i;
            // point p's parent to i
            parent[p] = parent[i];
            // i is no longer a leaf
            leaves[i] = 0;
            // p becomes a leaf
            leaves[p] = 1;
          }
        }
      }
    }
  }

  // validate that p is a valid index
  private void validate(int p) {
    int n = parent.length;
    if (p < 0 || p >= n) {
      throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
    }
  }

  /**
   * Reads an integer {@code n} and a sequence of pairs of integers (between
   * {@code 0} and {@code n-1}) from standard input, where each integer in the
   * pair represents some element; if the elements are in different sets, merge
   * the two sets and print the pair to standard output.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    UF3 uf3 = new UF3(n);
    for (int i = 0; i < m; i++) {
      int operation = in.nextInt();
      int s = in.nextInt();
      int t = in.nextInt();
      switch (operation) {
        case 0:
          System.out.println(uf3.find(s) == uf3.find(t) ? "1" : "0");
          break;
        case 1:
          uf3.union(s, t);
          break;
        case 2:
          // uf3.move(s, t);
          break;
      }
    }
  }
}

/******************************************************************************
 * Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
 *
 * This file is part of algs4.jar, which accompanies the textbook
 *
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 *
 *
 * algs4.jar is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * algs4.jar is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * algs4.jar. If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
