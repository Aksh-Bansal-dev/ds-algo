import java.util.*;
public class TopologicalSort{
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

        // for(int i=0;i<6;i++){
        //     System.out.println(adj[i]);
        // }
        int n = 6;
        res= new ArrayList<>();
        boolean vis[] = new boolean[6];
        vis[0] = true;
        dfs(adj, n, 0, vis);
        Collections.reverse(res);
        for(Integer e: res)
            System.out.print(e+" ");
        System.out.println();
    }

    static ArrayList<Integer> res;

    static void dfs(ArrayList<Integer>[] adj, int n, int node, boolean[] vis){
        // System.out.println("__"+node);
        for(Integer e: adj[node]){
            if(!vis[e]){
                vis[e] = true;
                dfs(adj,n, e, vis);
            }
        }
        res.add(node);
    }
}