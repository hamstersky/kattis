import edu.princeton.cs.algs4.BipartiteX;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Edge;


public class HarmonyConflict3 {
    public static void main(String[] args) {
        EdgeWeightedGraph g = new EdgeWeightedGraph(new In());
        WeightedBFS wbfs = new WeightedBFS(g, 0);
        System.out.println(wbfs.isHarmonious() ? 1 : 0);
    }
    
    static class WeightedBFS {
        private boolean[] marked;
        private boolean[] color;
        private boolean isHarmonious = true;
    

        public WeightedBFS(EdgeWeightedGraph G, int s) {
            marked = new boolean[G.V()];
            color = new boolean[G.V()];
            bfs(G, s);
        }

        public boolean isHarmonious() {
            return isHarmonious;
        }
    
        private void bfs(EdgeWeightedGraph G, int s) {
            Queue<Integer> q = new Queue<Integer>();
            marked[s] = true;
            q.enqueue(s);
            while (!q.isEmpty()) {
                int v = q.dequeue();
                for (Edge e : G.adj(v)) {
                    if (!marked[e.other(v)]) {
                        if ((e.weight() == 1)) {
                            color[e.other(v)] = !color[v];
                        } else {
                            color[e.other(v)] = color[v];
                        }
                        marked[e.other(v)] = true;
                        q.enqueue(e.other(v));
                    } else {
                        if ((e.weight() == 1 & color[e.other(v)] == color[v]) || (e.weight() == 0 & color[e.other(v)] != color[v])) {
                            isHarmonious = false;
                            return;
                        }
                    }
                }
            }
        }
    }
}