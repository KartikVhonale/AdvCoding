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
        if(visited[src]==false){
            visited[src]=true;
            boolean a=false;
            for(int i=0;i<graph[src].size();i++){
                a=haspath(graph, graph[src].get(i).nbr,dest, visited);
                if(a==true)return true;
            }
        }
        return false;
    }
    public static Boolean printpath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
        if(src==dest){
            System.out.print(src+" ");
            return true;
        }
        if(visited[src]==false){
            visited[src]=true;
            boolean a=false;
            for(int i=0;i<graph[src].size();i++){
                a=printpath(graph, graph[src].get(i).nbr,dest, visited);
                if(a==true){
                    System.out.print(src+" ");
                    return true;
                }
            }
        }
        return false;
    }
    public static void printAllpath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited,String s){
        if(src==dest){
            System.out.println(s);
            return ;
        }
        if(visited[src]==false){
            visited[src]=true;
            for(int i=0;i<graph[src].size();i++){
                printAllpath(graph, graph[src].get(i).nbr,dest, visited,s+graph[src].get(i).nbr);
            }
        }
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
            graph[nbr].add(new Edge(nbr,nbr, wt));
        }
        // for(int i=0;i<v;i++) System.out.println(graph[i].get(0).nbr);

        boolean[] visited=new boolean[v];
        Arrays.fill(visited, false);
        // boolean isTherePath=haspath(graph, 1, 4,visited);
        // System.out.println(isTherePath);
        String s="";
        // System.out.println(printpath(graph, 0, 6, visited,s));
        printAllpath(graph, 0, 6, visited,s);
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