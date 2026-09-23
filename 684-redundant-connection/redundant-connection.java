class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        // Initially, every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            // Already connected → this edge creates a cycle
            if (rootU == rootV) {
                return edge;
            }

            // Merge the two components
            parent[rootV] = rootU;
        }

        return new int[0];
    }

    private int find(int node) {
    while (parent[node] != node) { //Keep moving to the parent until parent[node] == node. That node is the root.
        node = parent[node];
    }
    return node;

}
}