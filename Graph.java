import java.util.*;
public class Graph {

    public static class Edge{

        int src;
        int nbr;
        int wt;
        
        Edge(int src,int nbr,int wt){
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    public static boolean haspath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
        if(src==dest)return true;
            visited[src]=true;
            boolean a=false;
            for(int i=0;i<graph[src].size();i++){
                if(!visited[graph[src].get(i).nbr]){
                    a=haspath(graph, graph[src].get(i).nbr,dest, visited);
                    if(a==true)return true;
                }
            }
            visited[src]=false;
        return false;
    }
    
    public static void printAllpath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String s){
        if(src==dest){
            System.out.println(s);
            return ;
        }
            visited[src]=true;
            for(int i=0;i<graph[src].size();i++){
                if(!visited[graph[src].get(i).nbr])
                printAllpath(graph, graph[src].get(i).nbr,dest, visited,s+graph[src].get(i).nbr);
            }
            visited[src]=false;
        return ;
    }
    public static void saveAllpaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,ArrayList<Integer> a,ArrayList<ArrayList<Integer>> b){
        if(src==dest){
            ArrayList<Integer> temp=new ArrayList<>(a);
            b.add(temp);
            return ;
        }
        visited[src]=true;
            for(int i=0;i<graph[src].size();i++){
                if(!visited[graph[src].get(i).nbr]){
                    a.add(graph[src].get(i).nbr);
                    saveAllpaths(graph, graph[src].get(i).nbr,dest, visited,a,b);
                    a.remove(a.size()-1);
                }
            }
        visited[src]=false;
        return ;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();

        ArrayList<Edge>[] graph =new ArrayList[v];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        sc.nextLine(); //for removing the effect of nextInt `:)_|
        for(int i=0;i<e;i++){
            String str=sc.nextLine();
            String[] arr= str.split(" ");
            int src = Integer.parseInt(arr[0]);
            int nbr = Integer.parseInt(arr[1]);
            int wt = Integer.parseInt(arr[2]);
            
            graph[src].add(new Edge(src,nbr, wt));
            graph[nbr].add(new Edge(nbr,src, wt));
        }
        // for(int i=0;i<v;i++) System.out.println(graph[i].get(0).nbr);

        boolean[] visited=new boolean[v];
        Arrays.fill(visited, false);
        // boolean isTherePath=haspath(graph, 1, 4,visited);
        // System.out.println(isTherePath);
        String s="";
        // System.out.println(printpath(graph, 0, 6, visited,s));
        printAllpath(graph, 0, 6, visited,s);
        
        
        boolean[] visited2=new boolean[v];
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<ArrayList<Integer>> b=new ArrayList<>();
        a.add(0);
        saveAllpaths(graph, 0, 6, visited2,a,b);
        System.out.println(b);
    }
}
// 7
// 8
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 5
// 4 6 8
// 5 6 3
// 4 5 3