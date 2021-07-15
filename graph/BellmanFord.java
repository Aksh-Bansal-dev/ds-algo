import java.util.*;
public class BellmanFord{
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
        int[] dis = new int[6];
        Arrays.fill(dis, 100000);
        dis[0] = 0;

        for(int i=0;i<n;i++){
            for(int[] e: adj[i]){
                if(dis[i]+e[1]<dis[e[0]]){
                    dis[e[0]] = dis[i]+e[1];
                }
            }
        }
        // For neg cycles
        for(int i=0;i<n;i++){
            for(int[] e: adj[i]){
                if(dis[i]+e[1]<dis[e[0]]){
                    dis[e[0]] = Integer.MIN_VALUE;
                }
            }
        }

        for(int e: dis){
            System.out.print(e+" ");
        }
        System.out.println();
    }
}
