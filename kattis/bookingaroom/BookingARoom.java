import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class BookingARoom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int N = in.nextInt();

        // If N is greater or equal to R then we know that all rooms are booked
        // and don't need to process the rest of the input
        if (N >= R) {
            System.out.println("too late");
            return;
        }
        System.out.println(arrayListSolution(R, N, in));
    }

    public static int setSolution(int R, int N, Scanner in) {
        HashSet<Integer> availableRooms = new HashSet<Integer>();
        for (int i = 1; i <= R; i++) {
            availableRooms.add(i);
        }

        HashSet<Integer> bookedRooms = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            bookedRooms.add(in.nextInt());
        }

        availableRooms.removeAll(bookedRooms);
        return availableRooms.iterator().next(); 
    }

    public static int arraySolution(int R, int N, Scanner in) {
        boolean[] bookedRooms = new boolean[R+1];
        for (int room = 0; room < N; room++) {
            bookedRooms[in.nextInt()] = true;
        }

        for (int room = 1; room <= R; room++) {
            if (!bookedRooms[room]) return room;
        }
        return -1;
    }

    public static int arrayListSolution(int R, int N, Scanner in) {
        // True = room booked, False = room available
        ArrayList<Boolean> rooms = new ArrayList<>();
        for (int i = 0; i <= R; i++) {
            rooms.add(false);
        }

        // Since room nr. 0 doesn't exist, let set it to be always booked
        rooms.set(0, true);

        for (int i = 0; i < N; i++) {
            rooms.set(in.nextInt(), true);
        }

        return rooms.indexOf(false);
    }
}