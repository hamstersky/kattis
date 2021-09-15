public class ReverseBinary {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int N = io.getInt();
        var rb = new ReverseBinary();
        System.out.println(rb.reversedBinary(N));
        // System.out.println(rb.cheating(N));
    }

    public static int cheating(int N) {
        String binaryString = Integer.toBinaryString(N);
        StringBuilder s = new StringBuilder(binaryString);
        String result = s.reverse().toString();
        return Integer.parseInt(result, 2);
    }

    public int reversedBinary(int x) {
        x = convertToBinary(x);
        x = reverseNumber(x);
        x = convertToDecimal(x);
        return x;
    }

    public int reverseNumber(int x) {
        int reversed = 0;
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed;
    }

    public int convertToDecimal(int x) {
        int decimal = 0;
        int i = 0;
        while (x > 0) {
            decimal += x % 10 * Math.pow(2, i);
            x /= 10;
            i++;
        }
        return decimal;
    }

    public int convertToBinary(int x) {
        int[] binary = new int[32];
        int i = 0;
        while (x > 0) {
            binary[i++] = x % 2;
            x = x / 2;
        }
        String result = "";
        for (int j = i - 1; j >= 0; j--) {
            result += binary[j];
        }
        return Integer.parseInt(result);
    }
}