import java.util.*;
public class Djikstra{
    public static void main(String[] args){
        ArrayList<int[]>[] adj = new ArrayList[6];
        for(int i=0;i<6;i++){
            adj[i] = new ArrayList<>();
        }
        adj[0].add(new int[]{1, 4});
        adj[0].add(new int[]{2, 3});
        adj[1].add(new int[]{3, 2});
        adj[1].add(new int[]{4, 1});
        adj[2].add(new int[]{3, 3});
        adj[2].add(new int[]{5, 4});

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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        int[] distance = new int[6];
        Arrays.fill(distance, 10000);
        distance[0] = 0;
        pq.offer(new int[]{0, 0});
        boolean[] vis = new boolean[6];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(!vis[cur[0]]){
                int e = cur[0];
                vis[e] = true;

                for(int[] neighbour: adj[e]){
                    int prev = distance[neighbour[0]];
                    distance[neighbour[0]] = Math.min(distance[neighbour[0]], distance[e]+neighbour[1]);
                    if(distance[neighbour[0]]<prev)
                        pq.offer(new int[]{neighbour[0], distance[neighbour[0]]});
                }
            } 
        }
        for(int e: distance){
            System.out.print(e+" ");
        }
        System.out.println();
    }

    // static ArrayList<Integer> topo;

    // static void dfs(ArrayList<Integer>[] adj, int n, int node, boolean[] vis){
    //     // System.out.println("__"+node);
    //     for(Integer e: adj[node]){
    //         if(!vis[e]){
    //             vis[e] = true;
    //             dfs(adj,n, e, vis);
    //         }
    //     }
    //     topo.add(node);
    // }
}