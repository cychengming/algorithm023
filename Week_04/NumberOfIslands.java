package leetcode;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int nr = grid.length;
		if (nr==0) return 0;
		int nc = grid[0].length;
		int numIslands = 0;
		for (int r =0;r<nr;r++){
			for(int c=0;c<nc;c++){
				if(grid[r][c]=='1'){
					numIslands++;
					dfs(grid,r,c);	//使用深度优先遍历将此岛屿都变为0；				
				}				
			}
		}
		return numIslands;
    }
    
	private void dfs(char[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;
		grid[r][c]='0';
		if(r-1>=0&&grid[r-1][c]=='1')dfs(grid,r-1,c);
		if(r+1<nr&&grid[r+1][c]=='1')dfs(grid,r+1,c);
		if(c-1>=0&&grid[r][c-1]=='1')dfs(grid,r,c-1);
		if(c+1<nc&&grid[r][c+1]=='1')dfs(grid,r,c+1);		
	}
	//使用广度优先搜索
	public int numIslandsTwo(char[][] grid) {
		int nr = grid.length;
		if (nr==0) return 0;
		int nc = grid[0].length;
		int numIslands = 0;
		for (int r =0;r<nr;r++){
			for(int c=0;c<nc;c++){
				if(grid[r][c]=='1'){
					numIslands++;
					grid[r][c]='0';			
				}				
			}
		}
		return numIslands;
    }

}
