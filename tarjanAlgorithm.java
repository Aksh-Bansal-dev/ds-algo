/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(;t>0;t--){
		    int numNodes = sc.nextInt();
		    int numEdges = sc.nextInt();
		    ArrayList<Integer>[] g = new ArrayList[numNodes];
		    for(int i=0;i<numNodes;i++){
		        g[i] = new ArrayList<>();
		    }
		    for(;numEdges>0;numEdges--){
		        int x = sc.nextInt();
		        int y = sc.nextInt();
		        g[x].add(y);
		    }
		    
		    List<List<Integer>> res = new ArrayList<List<Integer>>();
		    tarjan(numNodes, g, res);
		    for(int i=0;i<res.size();i++){
		        for(int j=0;j<res.get(i).size();j++){
		            System.out.print(res.get(i).get(j));
		            if(j!=res.get(i).size()-1)System.out.print(" ");
		        }
		        System.out.print(",");
		    }
		    System.out.println();
		}
	}
	
	private static void tarjan(int n, ArrayList<Integer>[] g, List<List<Integer>> res){
	    boolean[] vis = new boolean[n];
	    Stack<Integer> stack = new Stack<>();
	    int ids[] = new int[n];
	    int low[] = new int[n];
	    int id = 0;
	    
	    for(int i=0;i<n;i++){
	        if(!vis[i]){
	            dfs(i, g, res, vis, stack, ids, low, id);
	        }    
	    }
	    
	}
	
	private static void dfs(int node, ArrayList<Integer>[] g, List<List<Integer>> res
	,boolean[] vis , Stack<Integer> stack, int ids[] , int low[], int id){
	    ids[node] = low[node] = id++;
	    vis[node] = true;
	    stack.push(node);
	    for(Integer e: g[node]){
	        if(!vis[e]){
	            dfs(e, g, res, vis, stack, ids, low, id);
	            low[node] = Math.min(low[node], low[e]);
                
	        }
	        else if(vis[e] && stack.search(e)>-1){
	            low[node] = Math.min(low[node], low[e]);
	        }
	    }
	    if(low[node]==ids[node]){
	        List<Integer> scc = new ArrayList<>();
	        while(stack.peek()!=node){
	            scc.add(stack.pop());
	        }
	        scc.add(stack.pop());
	        res.add(scc);
	    }
	    
	}
	
	
}