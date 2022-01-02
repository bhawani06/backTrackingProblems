package backtrack;

public class RatMaze2 {
	 
    // Size of the maze
    static int N;
 
    int tot = 0;
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
    boolean findAllPath(int maze[][])
    {
        int sol[][] = new int[N][N];
        sol[0][0] = 1;
        int xMove[] = { 1,-1,0,0};
        int yMove[] = {0,0,-1,1};
        findAllPathUtil(maze, 0, 0, sol,xMove,yMove);
      System.out.println(tot);
        
 
       // printSolution(sol);
        return true;
    }
 
    /* A recursive utility function to solve Maze
    problem */
    void findAllPathUtil(int maze[][], int x, int y,
                          int sol[][] ,int xMove[],
                          int yMove[])
    {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1
            && maze[x][y] == 1) {

            printSolution(sol);
            
            ++tot;
            System.out.println(tot);
            return;
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
                  findAllPathUtil(maze, next_x, next_y,
                                  sol, xMove, yMove);
                  sol[next_x][next_y] = 0;
              }
          }
    	  return;
        
    }
 
    public static void main(String args[])
    {
        RatMaze2 rat = new RatMaze2();
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 1, 1 },
                         { 0, 1, 0, 1 },
                         { 1, 1, 1, 1 } };
 
        N = maze.length;
        rat.findAllPath(maze);
    }
}