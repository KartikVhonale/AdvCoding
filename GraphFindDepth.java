import java.util.*;

public class GraphFindDepth {

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
    public static class Pair2{
        int src;
        int time;
        Pair2(int src,int time){
            this.src=src;
            this.time=time;
        }
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
        boolean[] vis=new boolean[v];
        Arrays.fill(vis,false);
        int time=3;
        int src=6;
        Pair2 s=new Pair2(src,1);
        Queue<Pair2> q=new ArrayDeque<>();
        ArrayList<Integer> list=new ArrayList<>();
        q.add(s);
        while(!q.isEmpty()){
            Pair2 rem=q.remove();
            if(vis[rem.src])continue;
            vis[rem.src]=true;
            if(rem.time <= time) list.add(rem.src);
            else break;
            for(Edge edge:graph[rem.src]){
                q.add(new Pair2(edge.nbr,rem.time+1));
            }
        }
        System.out.println(list);
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