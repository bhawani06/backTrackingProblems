package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	   public static List<String> generateParenthesis(int n) {
		    ArrayList<String> result = new ArrayList<String>();
		    dfs(result, "", n, n);
		    return result;
		}
	   
	public static void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left > right || left<0 || right <0)
	        return;
	 
	    if(left==0&&right==0){
	        result.add(s);
	        return;
	    }
	        dfs(result, s+"(", left-1, right);
	 
	        dfs(result, s+")", left, right-1);
	}
	
	public static void main(String[] args) {
	
		System.out.println(generateParenthesis(3));
		
	}
}
