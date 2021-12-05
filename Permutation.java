package backtrack;

public class Permutation {
	public static void main(String args[]) 
	{ 
		permutation("123"); 
	} 
	public static void permutation(String input)
	{ 
		System.out.println(input.length()); 
		permutation("", input); 
	} 
	
	private static void permutation(String perm, String word) 
	{ 
		if (word.length()==0) 
		{ 
			System.out.println(perm);
		}
		else 
		{
			for (int i = 0; i < word.length(); i++)
			{ 
				permutation(perm + word.charAt(i), word.substring(0, i) 
		                + word.substring(i + 1, word.length()));
			
				//permutation(perm + word.charAt(i), word);
			} 
		} 
	}

	//Read more: https://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html#ixzz7AYMpKMki
}
