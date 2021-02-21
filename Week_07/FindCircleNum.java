package leetcode;
/*
 * 
 * 可以采用深度优先搜索和并查集进行解决
 * 
 * 
 */
public class FindCircleNum {
	public int findCircleNum(int[][] isConnected) {
		int[] visited = new int[isConnected.length];
		int count = 0;
		for (int i=0;i<isConnected.length;i++){
			if(visited[i]==0){
				dfs(isConnected,visited,i);
				count++;
			}
		}
		return count;
    }

	private void dfs(int[][] isConnected, int[] visited, int i) {
		for(int j=0;j<isConnected.length;j++){
			if(isConnected[i][j]==1&&visited[j]==0){
				visited[j]=1;
				dfs(isConnected,visited,j);
			}
		}		
	}
	
	public int findCircleNumTwo(int[][] isConnected) {
		int n = isConnected.length;
		UnionFind uf = new UnionFind(n);
		for(int i=0;i<n;i++){
			for(int j=i+1;i<n;i++){
				if(isConnected[i][j]==1){
					uf.union(i, j);
				}
			}
		}
		return uf.size;
    }
	class UnionFind{
		int[] roots;
		int size;//集合数量
		public UnionFind(int n){
			roots = new int[n];
			for(int i=0;i<n;i++){
				roots[i] = i;
			}
			size = n;
		}
		
		
		public int find(int i){
			if(i==roots[i]){
				return i;
			}
			return roots[i]=find(roots[i]);
		}
		public void union(int p, int q) {
			int pRoot = find(p);
			int qRoot = find(q);
			if(pRoot!=qRoot){
				roots[pRoot] =qRoot;
				size--;
			}		
		}
		
	}

	
}
