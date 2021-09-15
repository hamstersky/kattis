import java.util.Scanner;

import edu.princeton.cs.algs4.MaxPQ;

public class SeatAllocation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int nOfParties = in.nextInt();
    int nOfSeats = in.nextInt();
    MaxPQ<Party> pq = new MaxPQ<Party>(nOfParties);
    Party[] parties = new Party[nOfParties];

    for (int i = 0; i < nOfParties; i++) {
      Party p = new Party(in.nextInt());
      pq.insert(p);
      parties[i] = p;
    }

    for (int i = 0; i < nOfSeats; i++) {
      Party p = pq.delMax();
      p.addSeat();
      pq.insert(p);
    }

    for (Party p : parties) {
      System.out.println(p.getSeats());
    }
  }

  static class Party implements Comparable<Party> {
    private int votes;
    private int seats;
    private double quotient;

    public Party(int votes) {
      this.votes = votes;
      seats = 0;
      updateQuotient();
    }

    public int compareTo(Party o) {
      if (quotient > o.getQuotient()) {
        return 1;
      } else if (quotient < o.getQuotient()) {
        return -1;
      }
      return 0;
    }

    public double getQuotient() {
      return quotient;
    }

    public void addSeat() {
      seats++;
      updateQuotient();
    }

    public int getSeats() {
      return seats;
    }

    private void updateQuotient() {
      quotient = (double) votes / (seats + 1);
    }
  }
}