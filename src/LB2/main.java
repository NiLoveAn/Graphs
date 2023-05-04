package LB2;

import java.io.*;
import java.util.*;

public class LB2 {
    public static void main(String args[]) {
        System.out.println("Введите количество вершин:");
        Scanner s = new Scanner(System.in);
        int f = s.nextInt();
        Graph g = new Graph(f+1);         Graph1 g1 = new Graph1(f+1);
        String csvFile = "C:\\Users\\Andrey\\IdeaProjects\\LB_graphs\\grafs.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(cvsSplitBy);
                int[] array = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    array[i] = Integer.parseInt(arr[i]);
                    int X = Integer.parseInt(arr[0]);  int Y = Integer.parseInt(arr[i]);
                    g.addEdge(X,Y);                    g1.addEdge(X,Y);
                }
            }
        } 
        catch (FileNotFoundException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();} finally {
            if (br != null) { try { br.close(); } catch (IOException e) { e.printStackTrace(); } }  }

        long start = System.currentTimeMillis();
        System.out.println("BFS");
        g.BFS(0);                   //начальная вершина
        long start1 = System.currentTimeMillis();
        long start3 = System.nanoTime();
        System.out.println('\n');
        System.out.println("DFS");
        g1.DFS(0);
        long start2 = System.nanoTime();
        long s1 = start1 - start;
        long s2 = (start2 - start3)/1000000;
        System.out.println('\n');
        System.out.println(s1);
        System.out.println(s2);
    }
}