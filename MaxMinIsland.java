package backtrack;

public class MaxMinIsland {

	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	public static int area(int r, int c,int[][] g) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] == 0)
            return 0;
        g[r][c] = 0;
        return (1 + area(r+1, c,g) + area(r-1, c,g)
                  + area(r, c-1,g) + area(r, c+1,g));
    }

    public static int maxAreaOfIsland(int[][] grid) 
    {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
            	if(grid[r][c]==1)
            	{	ans = Math.max(ans, area(r, c,grid));
            		if(ans<min) min = ans;
            		if(ans>max) max = ans;
            	}
                
            }
        }
        return ans;
    }
    public static void main(String[] args) {
		int[][] grid = {
				{0,0,1,1,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}
				};
		
		maxAreaOfIsland(grid);
		
		System.out.println(min);
		System.out.println(max);
	}
}