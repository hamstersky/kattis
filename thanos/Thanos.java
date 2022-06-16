public class Thanos {
    public static void main(String[] args) {
        Kattio in = new Kattio(System.in);
        int T = in.getInt();
        for (int i = 0; i < T; i++) {
            int p = in.getInt();
            int r = in.getInt();
            int f = in.getInt();
            if (p > f) {
                System.out.println(0);
            }
            int years = 0;
            while (f >= p) {
                f = f / r;
                years++;
            }
            if (p * Math.pow(r, years) < f) {
                years++;
            }
            System.out.println(years);
        }
    }
}