import java.util.*;

import javafx.util.Pair;
public class GraphTravarse {

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
    public static class Pair{
        int src;
        String path;
        Pair(int src,String path){
            this.src=src;
            this.path=path;
        }
    }
    public static void bfs(ArrayList<Edge>[]graph,int src,boolean[] vis){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,""));
        vis[src]=true;
        while(!q.isEmpty()){
            Pair rem=q.remove();
            System.out.print(rem.src+"->");
            for(Edge e:graph[rem.src]){
                if(!vis[e.nbr]){
                    vis[e.nbr]=true;
                    q.add(new Pair(e.nbr,rem.path+"->"+e.nbr));
                }
            }
        }
    }
    public static boolean bfs2(ArrayList<Edge>[]graph,int src,boolean[] vis){
        // if(vis[src]==true)return false;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,""));
        vis[src]=true;
        while(!q.isEmpty()){
            Pair rem=q.remove();
            if(vis[rem.src]==true)return true;
            vis[rem.src]=true;
            for(Edge e:graph[rem.src]){
                if(!vis[e.nbr]){
                    q.add(new Pair(e.nbr,rem.path+"->"+e.nbr));
                }
            }
        }
        return false;
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
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        bfs(graph, 0, vis);

        boolean flag=false;
        boolean[] vis2=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis2[i]){
                flag=bfs2(graph,0,vis2);
                if(flag==true)break;
            }
        }
        System.out.println(flag);
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