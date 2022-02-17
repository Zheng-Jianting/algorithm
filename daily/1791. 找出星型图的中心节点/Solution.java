class Solution {
    public int findCenter(int[][] edges) {
        int[] lastEdge = edges[edges.length - 1];
        for(int[] edge : edges) {
            if(lastEdge[0] != edge[0] && lastEdge[0] != edge[1]) {
                return lastEdge[1];
            }
            if(lastEdge[1] != edge[0] && lastEdge[1] != edge[1]) {
                return lastEdge[0];
            }
        }
        return -1;
    }
}