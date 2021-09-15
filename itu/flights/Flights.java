import edu.princeton.cs.algs4.RedBlackBST;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Flights {
    private RedBlackBST<String, String> bst;

    public static void main(String[] args) {
        Flights f = new Flights();
        Kattio k = new Kattio(System.in, System.out);
        int n = k.getInt();
        int m = k.getInt();
        for (int i = 0; i < n; i++) {
            String time = k.getWord();
            String dest = k.getWord();
            f.add(time, dest);
        }
        for (int j = 0; j < m; j++) {
            String operation = k.getWord();
            switch(operation) {
                case "cancel":
                    f.cancel(k.getWord());
                    break;
                case "delay":
                    String time = k.getWord();
                    int d = k.getInt();
                    f.delay(time, d);
                    break;
                case "reroute":
                    f.reroute(k.getWord(), k.getWord());
                    break;
                case "destination":
                    f.destination(k.getWord());
                    break;
                case "next":
                    f.next(k.getWord());
                    break;
                case "count":
                    f.count(k.getWord(), k.getWord());
                    break;
                default:
                    break;
            }
        }
    }

    public Flights() {
        bst = new RedBlackBST<String, String>();
    }

    private void add(String time, String dest) {
        bst.put(time, dest);
    }

    private void cancel(String flight) {
        bst.delete(flight);
    }

    private void delay(String flight, int d) {
        String dest = bst.get(flight);
        if (dest != null) {
            String time = format_time(flight, d);
            bst.delete(flight);
            bst.put(time, dest);
        }
    }

    private void reroute(String flight, String new_dest) {
        bst.put(flight, new_dest);
    }

    private void destination(String flight) {
        String dest = bst.get(flight);
        System.out.println(dest == null ? "-" : dest);
    }

    private void next(String flight) {
        String time = "";
        try {
            time = bst.ceiling(flight);
        } catch (Exception e) {
            time = bst.ceiling("00:00:00");
        }
        String dest = bst.get(time);
        System.out.println(time + " " + dest);
    }

    private void count (String time1, String time2) {
        System.out.println(bst.size(time1, time2));
    }

    private static String format_time(String time, int d) {
        String[] split = time.split(":");
        int h = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int s = Integer.parseInt(split[2]);
        s += d;
        if (s >= 60) {
            m += s / 60;
            s = s % 60;
        }
        if (m >= 60) {
            h += m / 60;
            m = m % 60;
        }
        if (h >= 24) {
            h = h % 24;
        }

        String formattedTime = "";
        if (h < 10) {
            formattedTime += "0";
        }
        formattedTime = formattedTime + h + ":";
        if (m < 10) {
            formattedTime += "0";
        }
        formattedTime = formattedTime + m + ":";
        if (s < 10) {
            formattedTime += "0";
        }
        formattedTime = formattedTime + s;
        return formattedTime;
    }
}

// The MIT License (MIT)

// Copyright (c) 2011-2015 Kattis

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in
// all
// copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

/**
 * Simple yet moderately fast I/O routines.
 *
 * Example usage:
 *
 * Kattio io = new Kattio(System.in, System.out);
 *
 * while (io.hasMoreTokens()) { int n = io.getInt(); double d = io.getDouble();
 * double ans = d*n;
 *
 * io.println("Answer: " + ans); }
 *
 * io.close();
 *
 *
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 * Kattio-instance, otherwise, you may lose output.
 *
 * - The getInt(), getDouble(), and getLong() methods will throw an exception if
 * there is no more data in the input, so it is generally a good idea to use
 * hasMoreTokens() to check for end-of-file.
 *
 * @author: Kattis
 */

class Kattio extends PrintWriter {
	public Kattio(InputStream i) {
		super(new BufferedOutputStream(System.out));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public Kattio(InputStream i, OutputStream o) {
		super(new BufferedOutputStream(o));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public boolean hasMoreTokens() {
		return peekToken() != null;
	}

	public int getInt() {
		return Integer.parseInt(nextToken());
	}

	public double getDouble() {
		return Double.parseDouble(nextToken());
	}

	public long getLong() {
		return Long.parseLong(nextToken());
	}

	public String getWord() {
		return nextToken();
	}

	private BufferedReader r;
	private String line;
	private StringTokenizer st;
	private String token;

	private String peekToken() {
		if (token == null)
			try {
				while (st == null || !st.hasMoreTokens()) {
					line = r.readLine();
					if (line == null)
						return null;
					st = new StringTokenizer(line);
				}
				token = st.nextToken();
			} catch (IOException e) {
			}
		return token;
	}

	private String nextToken() {
		String ans = peekToken();
		token = null;
		return ans;
	}
}
