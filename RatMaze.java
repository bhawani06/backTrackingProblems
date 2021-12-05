package backtrack;

public class RatMaze {
	 
    // Size of the maze
    static int N;
 
    /* A utility function to print
    solution matrix sol[N][N] */
    void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                    " " + sol[i][j] + " ");
            System.out.println();
        }
    }
 
    /* A utility function to check
        if x, y is valid index for N*N maze */
    boolean isSafe(
        int maze[][], int x, int y, int sol[][])
    {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0
                && y < N && maze[x][y] == 1 && sol[x][y]==0);
    }
 
    /* This function solves the Maze problem using
    Backtracking. It mainly uses solveMazeUtil()
    to solve the problem. It returns false if no
    path is possible, otherwise return true and
    prints the path in the form of 1s. Please note
    that there may be more than one solutions, this
    function prints one of the feasible solutions.*/
    boolean solveMaze(int maze[][])
    {
        int sol[][] = new int[N][N];
        sol[0][0] = 1;
        int xMove[] = { 1,-1,0,0};
        int yMove[] = {0,0,-1,1};
        if (solveMazeUtil(maze, 0, 0, sol,xMove,yMove) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }
 
        printSolution(sol);
        return true;
    }
 
    /* A recursive utility function to solve Maze
    problem */
    boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][] ,int xMove[],
                          int yMove[])
    {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1
            && maze[x][y] == 1) {
            return true;
        }
        
 
        // Check if maze[x][y] is valid
      
              // Check if the current block is already part of solution path.   

          int k, next_x, next_y;
    	  for (k = 0; k < 4; k++) 
    	  {
              next_x = x + xMove[k];
              next_y = y + yMove[k];
              if (isSafe(maze, next_x, next_y, sol)) 
              {
                  sol[next_x][next_y] = 1;
                  if (solveMazeUtil(maze, next_x, next_y,
                                  sol, xMove, yMove))
                      return true;
                  else
                      sol[next_x][next_y] = 0; // backtracking
              }
          }
            return false;
        
    }
 
    public static void main(String args[])
    {
        RatMaze rat = new RatMaze();
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
 
        N = maze.length;
        rat.solveMaze(maze);
    }
}