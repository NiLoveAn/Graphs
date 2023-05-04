import java.util.*;
import java.io.*;

public class LB1 {
    public int vertices;
    public int edges;
    final int MAX_LIMIT = 20;
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    public List<List<Integer> > adjacencyList;

    public LB1() {
        this.vertices = scan.nextInt() + 1;
        this.edges = random.nextInt(computeMaxEdges(vertices)) + 1;
        adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++)
            adjacencyList.add(new ArrayList<>());

        for (int i = 0; i < edges; i++) {
            int v = random.nextInt(vertices);
            int w = random.nextInt(vertices);

            if (adjacencyList.get(v).contains(w)) {
                i = i - 1;
                continue;
            }

            addEdge(v, w);
        }
    }

    int computeMaxEdges(int numOfVertices) {
        return numOfVertices * ((numOfVertices - 1) / 2);
    }

    void addEdge(int v, int w) {
        adjacencyList.get(v).add(w);
        if (v != w)     adjacencyList.get(w).add(v);
    }

    public static void main(String[] args) {
        try {
            Random r =new Random();
            System.out.println("Введите количество вершин:");
            PrintWriter writer = new PrintWriter(new File("grafs.csv"));
            StringBuilder sb = new StringBuilder();
            LB1 randomGraph = new LB1();
            for (int i = 0; i < randomGraph.adjacencyList.size(); i++) {
                sb.append(i);
                sb.append(',');
                //sb.append("Vertice is connected to:");
                //sb.append(',');
                List<Integer> list = randomGraph.adjacencyList.get(i);

                if (list.isEmpty())     sb.append(" No adjacent vertices ");
                else {
                    int size = list.size();

                    for (int j = 0; j < size; j++) {
                        sb.append(list.get(j));
                        sb.append(" ");
                        sb.append(new Random().ints(1, 1, 10000).findFirst().getAsInt());

                        if (j < size - 1)
                            sb.append(',');
                    }
                }
                sb.append('\n');
            }
            writer.write(sb.toString());
            writer.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
