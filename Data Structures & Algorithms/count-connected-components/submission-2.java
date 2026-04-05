public class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        //build individual components
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=i;
        }
    }
    public int find(int node){
        int curr=node;
        while(curr!=parent[curr]){
            //path compression
            parent[curr]=parent[parent[curr]];
            curr=parent[curr];
        }
        return curr;
    }
    public boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pv==pu){
            return false;
        }
        if(rank[pv]>rank[pu]){
            //we swap the root now higher rank becomes the root
            int temp=pu;
            pu=pv;
            pv=temp;
        }
        //v becomes a child of u
        parent[pv]=pu;
        //size of root (indicating how many nodes it has under it)
        rank[pu]+=rank[pv];
        return true;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu=new DSU(n);
        //total individual components
        int components=n;
        for(int[] edge:edges){
            if(dsu.union(edge[0],edge[1])){
                //a component was build
                components--;
            }
        }
        return components;
    }
}
