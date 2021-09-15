import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Edge;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class HarmonyConflict {
    private boolean[] marked;
    private boolean[] color;
    private boolean isHarmonious = true;
    private EdgeWeightedGraph graph;

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int V = io.getInt();
        int E = io.getInt();
        EdgeWeightedGraph graph = new EdgeWeightedGraph(V);
        for (var i = 0; i < E; i++) {
            int v = io.getInt();
            int w = io.getInt();
            double weight = (double) io.getInt();
            Edge e = new Edge(v, w, weight);
            graph.addEdge(e);
        }
        HarmonyConflict hc = new HarmonyConflict(graph);
        hc.bfs();
        System.out.println(hc.isHarmonious() ? 1 : 0);
    }

    public HarmonyConflict(EdgeWeightedGraph graph) {
        this.graph = graph;
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];
    }

    public boolean isHarmonious() {
        return isHarmonious;
    }

    private void bfs() {
        Queue<Integer> q = new Queue<Integer>();
        marked[0] = true;
        q.enqueue(0);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (Edge e : graph.adj(v)) {
                if (!marked[e.other(v)]) {
                    if ((e.weight() == 1)) {
                        color[e.other(v)] = !color[v];
                    } else {
                        color[e.other(v)] = color[v];
                    }
                    marked[e.other(v)] = true;
                    q.enqueue(e.other(v));
                } else {
                    if ((e.weight() == 1 & color[e.other(v)] == color[v])
                            || (e.weight() == 0 & color[e.other(v)] != color[v])) {
                        isHarmonious = false;
                        return;
                    }
                }
            }
        }
    }

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

    static class Kattio extends PrintWriter {
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

}
