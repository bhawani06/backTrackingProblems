package backtrack;

public class WordSearch1 {

	public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
       
       for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board[i].length; j++){
               if(search(board,visited, word, i, j, 0)){
                   return true;
               }
           }
       }
       
       return false;
   }
   
   private static boolean search(char[][]board,  boolean[][] visited,String word, int i, int j, int index){
       if(index == word.length()){
           return true;
       }
       
       if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
           return false;
       }
       
       visited[i][j] = true;
       if(search(board, visited,word, i-1, j, index+1) || 
          search(board, visited, word, i+1, j, index+1) ||
          search(board, visited, word, i, j-1, index+1) || 
          search(board, visited,word, i, j+1, index+1)){
           return true;
       }
       
       visited[i][j] = false;
       return false;
   }
	public static void main(String[] args) {
		char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(exist(board,"ABCCED"));

	}

}
