import java.util.*;
public class SSSPDAG{
    public static void main(String[] args){
        ArrayList<Integer>[] adj = new ArrayList[6];
        for(int i=0;i<6;i++){
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(3);
        adj[1].add(4);
        adj[2].add(3);
        adj[2].add(5);

        /**
                    4
                  /
                1
              /   \
            0       3
              \   /
                2
                  \
                    5
         */


        int n = 6;
        topo= new ArrayList<>();
        boolean vis[] = new boolean[6];
        vis[0] = true;
        dfs(adj, n, 0, vis);
        Collections.reverse(topo);

        // Assuming distance between all edges is 1
        int[] distance = new int[6];
        Arrays.fill(distance, 10000);
        distance[topo.get(0)] = 0;
        for(Integer e: topo){
            for(Integer neighbour: adj[e]){
                distance[neighbour] = Math.min(distance[neighbour], distance[e]+1);
            } 
        }
        for(int e: distance){
            System.out.print(e+" ");
        }
        System.out.println();
    }

    static ArrayList<Integer> topo;

    static void dfs(ArrayList<Integer>[] adj, int n, int node, boolean[] vis){
        // System.out.println("__"+node);
        for(Integer e: adj[node]){
            if(!vis[e]){
                vis[e] = true;
                dfs(adj,n, e, vis);
            }
        }
        topo.add(node);
    }
}